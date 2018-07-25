package com.jianpanmao.wechat.web;

import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.utils.HttpServletUtils;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-05-08 22:00
 */

@Controller
@RequestMapping("menu")
public class WxMenuController {

    @Autowired private WxApiHandler wxApiHandler;

    @PostMapping
    @ResponseBody
    @NoResultEntity
    public String create(Integer wxPublicId, String json, HttpSession session){

        try {
            WxUtils.checkParam(session, wxPublicId);
            String accessToken = WxUtils.getAccessToken(session, wxPublicId);
            return wxApiHandler.createMenu(accessToken, json);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping
    @ResponseBody
    @NoResultEntity
    public String delete(Integer wxPublicId, HttpSession session){

        try {
            WxUtils.checkParam(session, wxPublicId);
            String accessToken = WxUtils.getAccessToken(session, wxPublicId);
            return wxApiHandler.deleteMenu(accessToken);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping
    @ResponseBody
    @NoResultEntity
    public void get(Integer wxPublicId, HttpSession session, HttpServletResponse response) throws Exception {

        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            WxUtils.checkParam(session, wxPublicId);
            String accessToken = WxUtils.getAccessToken(session, wxPublicId);
            HttpServletUtils.responseWriter(response, wxApiHandler.getMenu(accessToken));
        } catch (Exception e) {
            HttpServletUtils.responseWriter(response, e.getMessage());
        }
    }


}
