package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.GsonUtils;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import com.jianpanmao.wechat.api.news.WxNewsContent;
import com.jianpanmao.wechat.dto.VideoDTO;
import com.jianpanmao.wechat.entity.WxMaterial;
import com.jianpanmao.wechat.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zdc
 * @since 2018-05-01 21:27
 */
@Controller
@RequestMapping("material")
public class WxMaterialController {

    @Autowired private WxMaterialService wxMaterialService;

    @Autowired private WxApiHandler wxApiHandler;

    @PostMapping("upload")
    @ResponseBody
    public ResponseEntity add(WxMaterial wxMaterial, MultipartFile media, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            wxMaterialService.insert(wxMaterial, WxUtils.getAccessToken(session, wxMaterial.getWxPublicId()), media);
            responseEntity.setStatus("200");
            responseEntity.setMessages("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("添加异常" + e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("upload/news")
    @ResponseBody
    public ResponseEntity addNews(@RequestBody WxNewsContent wxNewsContent, HttpSession session){

        ResponseEntity responseEntity = new ResponseEntity();
        try {
            wxMaterialService.insertWxNews(wxNewsContent, WxUtils.getAccessToken(session, wxNewsContent.getWxPublicId()));
            responseEntity.setStatus("200");
            responseEntity.setMessages("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
        }
        return responseEntity;
    }

    @GetMapping("page")
    @ResponseBody
    public Object pageList(Integer page, Integer rows, WxMaterial wxMaterial, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            WxUtils.checkParam(session, wxMaterial.getWxPublicId());
            PageHelper.startPage(page, rows);
            wxMaterial.setIntermediary(WxUtils.getCompany(session));
            List<WxMaterial> list = wxMaterialService.selectAll(wxMaterial);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(pageInfo);
            return responseEntity;
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            return responseEntity;
        }
    }

    @GetMapping("video/detail")
    @ResponseBody
    public VideoDTO videoDetail(String mediaId, Integer wxPublicId, HttpSession session) throws Exception{
        String result = null;
        WxUtils.checkParam(session, wxPublicId);
        String accessToken = WxUtils.getAccessToken(session, wxPublicId);
        result = wxApiHandler.getVideoDetail(accessToken, mediaId);
        return GsonUtils.toBean(result, VideoDTO.class);
    }

    @NoResultEntity
    @GetMapping("voice/detail")
    @ResponseBody
    public void voiceDetail(String name, String mediaId, Integer wxPublicId, HttpSession session, HttpServletResponse response) throws Exception{
        response.addHeader("Content-Type","audio/mp3");
        response.addHeader("Content-Disposition", "attachment;filename=" + name);
        WxUtils.checkParam(session, wxPublicId);
        String accessToken = WxUtils.getAccessToken(session, wxPublicId);
        wxApiHandler.getStreamDetail(accessToken, mediaId, response);
    }

    @NoResultEntity
    @GetMapping("image/detail")
    public void imageDetail(String name, Integer wxPublicId, String mediaId,HttpServletResponse response,HttpSession session) throws Exception{
        response.addHeader("Content-Type","image/jpeg");
//        response.addHeader("Content-Disposition", "attachment;filename=" + name);
        WxUtils.checkParam(session, wxPublicId);
        String accessToken = WxUtils.getAccessToken(session, wxPublicId);
        wxApiHandler.getStreamDetail(accessToken, mediaId, response);
    }

    @GetMapping("news/detail")
    @ResponseBody
    public WxMaterial newsDetail(Integer materialId, Integer wxPublicId, HttpSession session) throws Exception{
        WxUtils.checkParam(session, wxPublicId);
        return wxMaterialService.selectByPrimaryKey(materialId);
    }

    @GetMapping("news/detailByWxMediaId")
    @ResponseBody
    public WxMaterial detailByWxMediaId(String materialId, Integer wxPublicId, HttpSession session) throws Exception{
        WxUtils.checkParam(session, wxPublicId);
        return wxMaterialService.findByMediaId(materialId);
    }
}
