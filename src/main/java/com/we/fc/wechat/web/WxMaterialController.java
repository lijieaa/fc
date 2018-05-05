package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.base.BaseTokenController;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.news.WxNewsContent;
import com.we.fc.wechat.entity.WxMaterial;
import com.we.fc.wechat.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

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

}
