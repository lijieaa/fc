package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.http.RequestTools;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.GsonUtils;
import com.jianpanmao.utils.WxUtils;
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
    public ResponseEntity pageList(Integer page, Integer rows, WxMaterial wxMaterial, HttpSession session) {
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

    @GetMapping("detail")
    @ResponseBody
    public VideoDTO detail(String mediaId, Integer wxPublicId, HttpSession session) throws Exception{
        String result = null;
        WxUtils.checkParam(session, wxPublicId);
        String accessToken = WxUtils.getAccessToken(session, wxPublicId);
        result = wxMaterialService.getMaterialDetail(accessToken, mediaId);
        return GsonUtils.toBean(result, VideoDTO.class);
    }

    @GetMapping("image/detail")
    @ResponseBody
    public void imageDetail(String name, String url, HttpServletResponse response){

        response.setHeader("Content-Type","image/jpeg");
        response.setHeader("Content-Disposition","attachment;filename=\"" + name + "\"");
        RequestTools.processImageDownload(url, response);
    }
}
