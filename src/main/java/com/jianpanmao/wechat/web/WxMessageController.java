package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.FileUtils;
import com.jianpanmao.utils.GsonUtils;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.msg.*;
import com.jianpanmao.wechat.entity.WxMessage;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 18:03
 */

@Controller
@RequestMapping("message")
public class WxMessageController{

    @Autowired private WxMessageService wxMessageService;

    @Value("${fc.wx.user-msg-material.path}")
    private String filepath;

    @PreAuthorize("hasAuthority('wxmsg:view')")
    @GetMapping("page")
    @ResponseBody
    public Object page(Integer page,
                               Integer rows,
                               Integer wxPublicId,
                                @RequestParam(value = "draw", required = false) Integer draw,
                               HttpSession session) throws Exception{
        WxUtils.checkParam(session, wxPublicId);
        PageHelper.startPage(page,rows);
        List<WxMessage> list = wxMessageService.findByPublicId(wxPublicId);
        PageInfo pageInfo = new PageInfo(list);
        if (draw != null) {
            DataTablesResponseEntity<Project> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }

    @PreAuthorize("hasAuthority('wxmsg:view')")
    @GetMapping("user/page")
    @ResponseBody
    public Object pageForUser(Integer page,
                               Integer rows,
                               String openId,
                               Integer wxPublicId,
                               @RequestParam(value = "draw", required = false) Integer draw,
                               HttpSession session) throws Exception {
        WxPublic wxPublic = WxUtils.checkParam(session, wxPublicId);
        PageHelper.startPage(page,rows);
        List<WxMessage> list = wxMessageService.findBySourceIdAndOpenId(wxPublic.getSourceId(), openId);
        PageInfo pageInfo = new PageInfo(list);
        if (draw != null) {
            DataTablesResponseEntity<Project> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }

    @PreAuthorize("hasAuthority('wxmsg:send')")
    @PostMapping
    @ResponseBody
    public ResponseEntity sendMsg(@RequestParam("wxPublicId")Integer wxPublicId,
                                  @RequestParam("json") String json,
                                  HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        WxMessage wxMessage = GsonUtils.toBean(json, WxMessage.class);
        try {
            String accessToken = WxUtils.getAccessToken(session, wxPublicId);
            WxPublic wxPublic = WxUtils.checkParam(session, wxPublicId);
            wxMessage.setFromUserName(wxPublic.getSourceId());
            wxMessageService.sendMsg2user(accessToken, getMsg(wxMessage), wxMessage);
            responseEntity.setMessages("发送成功");
            responseEntity.setStatus("200");
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            e.printStackTrace();
        }
        return responseEntity;
    }

    private Msg getMsg(WxMessage wxMessage){

        Msg msg = null;
        if(wxMessage.getMsgType().equalsIgnoreCase("text")){
            msg = new TextMsg(new TextMsgContent(wxMessage.getContent()));
        }else if(wxMessage.getMsgType().equalsIgnoreCase("image")){
            ImageMsgContent imageMsgContent = new ImageMsgContent(wxMessage.getMediaId());
            msg = new ImageMsg(imageMsgContent);
        }else if(wxMessage.getMsgType().equalsIgnoreCase("voice")){
            VoiceMsgContent voiceMsgContent = new VoiceMsgContent(wxMessage.getMediaId());
            msg = new VoiceMsg(voiceMsgContent);
        }else if(wxMessage.getMsgType().equalsIgnoreCase("video")){
            VideoMsgContent videoMsgContent = new VideoMsgContent();
            videoMsgContent.setMedia_id(wxMessage.getMediaId());
            videoMsgContent.setDescription(wxMessage.getDescription());
            videoMsgContent.setThumb_media_id(wxMessage.getThumbMediaId());
            videoMsgContent.setTitle(wxMessage.getTitle());
            msg = new VideoMsg(videoMsgContent);
        }else if(wxMessage.getMsgType().equalsIgnoreCase("news")){
            ImageTextMsgContentArticle imageTextMsgContentArticle = new ImageTextMsgContentArticle();
            imageTextMsgContentArticle.setDescription(wxMessage.getDescription());
            imageTextMsgContentArticle.setPicurl(wxMessage.getPicUrl());
            imageTextMsgContentArticle.setTitle(wxMessage.getTitle());
            imageTextMsgContentArticle.setUrl(wxMessage.getUrl());
            ImageTextMsgContent imageTextMsgContent = new ImageTextMsgContent(Arrays.asList(imageTextMsgContentArticle));
            msg = new ImageTextMsg(imageTextMsgContent);
        }else if(wxMessage.getMsgType().equalsIgnoreCase("mpnews")){
            ImageText2MsgContent imageText2MsgContent = new ImageText2MsgContent(wxMessage.getMediaId());
            msg = new ImageText2Msg(imageText2MsgContent);
        }
        msg.setTouser(wxMessage.getToUserName());
        msg.setMsgtype(wxMessage.getMsgType());
        return msg;
    }

    @PreAuthorize("hasAuthority('wxmsg:view')")
    @GetMapping("attachment")
    @ResponseBody
    @NoResultEntity
    public void attachment(String msgType, String localFile, HttpServletResponse response) throws Exception {

        String contentType = null;
        if(msgType.equalsIgnoreCase("image")){
            contentType = "image/jpeg";
        }else if(msgType.equalsIgnoreCase("voice")){
            contentType = "audio/mp3";
        }else if(msgType.equalsIgnoreCase("video")){
            contentType = "video/mp4";
        }
        response.setHeader("Content-Type", contentType);
        response.addHeader("Content-Disposition", "attachment;filename=" + localFile);
        FileUtils.download(new File(filepath + localFile), response);
    }
}
