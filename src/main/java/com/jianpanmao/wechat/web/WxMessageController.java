package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.GsonUtils;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.msg.*;
import com.jianpanmao.wechat.entity.WxMessage;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("page")
    @ResponseBody
    public ResponseEntity page(Integer page,
                               Integer rows,
                               Integer wxPublicId,
                               HttpSession session) throws Exception{
        ResponseEntity responseEntity = new ResponseEntity();
        WxUtils.checkParam(session, wxPublicId);
        PageHelper.startPage(page,rows);
        List<WxMessage> list = wxMessageService.findByPublicId(wxPublicId);
        PageInfo pageInfo = new PageInfo(list);
        responseEntity.setData(Arrays.asList(pageInfo));
        return responseEntity;
    }

    @GetMapping("user/page")
    @ResponseBody
    public ResponseEntity pageForUser(Integer page,
                               Integer rows,
                               String openId,
                               Integer wxPublicId,
                               HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            WxPublic wxPublic = WxUtils.checkParam(session, wxPublicId);
            PageHelper.startPage(page,rows);
            List<WxMessage> list = wxMessageService.findBySourceIdAndOpenId(wxPublic.getSourceId(), openId);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(Arrays.asList(pageInfo));
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("获取失败"+e.getMessage());
            return responseEntity;
        }
    }

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
}
