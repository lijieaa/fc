package com.jianpanmao.wechat.web;

import com.jianpanmao.http.RequestTools;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.GsonUtils;
import com.jianpanmao.wechat.api.news.WxNewsContent;
import com.jianpanmao.wechat.base.BaseController;
import com.jianpanmao.wechat.base.BaseService;
import com.jianpanmao.wechat.base.BaseTokenController;
import com.jianpanmao.wechat.entity.WxMaterial;
import com.jianpanmao.wechat.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author zdc
 * @since 2018-05-01 21:27
 */
@Controller
@RequestMapping("material")
public class WxMaterialController extends BaseController<WxMaterial> {

    @Autowired private WxMaterialService wxMaterialService;

    private BaseTokenController baseTokenController;

    public WxMaterialController(){
        this.baseTokenController = new BaseTokenController();
    }

    @Override
    public BaseService getService() {
        return wxMaterialService;
    }

    @Override
    protected ResponseEntity hookExist(WxMaterial wxMaterial) {
        return null;
    }

    @PostMapping("upload")
    @ResponseBody
    public ResponseEntity add(WxMaterial wxMaterial, MultipartFile media, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            wxMaterialService.insert(wxMaterial,baseTokenController.getAccessToken(session, wxMaterial.getWxPublicId()), media);
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
            wxMaterialService.insertWxNews(wxNewsContent, baseTokenController.getAccessToken(session, wxNewsContent.getWxPublicId()));
            responseEntity.setStatus("200");
            responseEntity.setMessages("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
        }
        return responseEntity;
    }

    @Override
    @GetMapping("page")
    @ResponseBody
    public ResponseEntity pageList(Integer page, Integer rows, WxMaterial wxMaterial, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            baseTokenController.checkParam(session, wxMaterial.getWxPublicId());
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            return responseEntity;
        }
        return super.pageList(page, rows, wxMaterial, session);
    }

    @GetMapping("detail")
    @ResponseBody
    public String detail(String mediaId, Integer wxPublicId, HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        String result = null;
        try {
            baseTokenController.checkParam(session, wxPublicId);
            String accessToken = baseTokenController.getAccessToken(session, wxPublicId);
            result = wxMaterialService.getMaterialDetail(accessToken, mediaId);
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            return GsonUtils.toJson(responseEntity);
        }
        return result;
    }

    @GetMapping("image/detail")
    @ResponseBody
    public void imageDetail(String name, String url, HttpServletResponse response){

        response.setHeader("Content-Type","image/jpeg");
        response.setHeader("Content-Disposition","attachment;filename=\"" + name + "\"");
        RequestTools.processImageDownload(url, response);
    }
}
