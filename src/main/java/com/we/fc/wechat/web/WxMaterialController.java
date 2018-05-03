package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.base.BaseTokenController;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.wechat.entity.WxMaterial;
import com.we.fc.wechat.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
            wxMaterialService.insert(wxMaterial,baseTokenController.getAccessToken(session), media);
            responseEntity.setStatus("200");
            responseEntity.setMessages("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("添加异常" + e.getMessage());
        }
        return responseEntity;
    }
}
