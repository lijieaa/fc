package com.we.fc.wechat.web;

import com.we.fc.base.BaseTokenController;
import com.we.fc.wechat.api.WxApiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-05-08 22:00
 */

@Controller
@RequestMapping("menu")
public class WxMenuController extends BaseTokenController {

    @Autowired private WxApiHandler wxApiHandler;

    @PostMapping
    @ResponseBody
    public String create(Integer wxPublicId, String json, HttpSession session){

        try {
            checkParam(session, wxPublicId);
            String accessToken = getAccessToken(session, wxPublicId);
            return wxApiHandler.createMenu(accessToken, json);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping
    @ResponseBody
    public String delete(Integer wxPublicId, HttpSession session){

        try {
            checkParam(session, wxPublicId);
            String accessToken = getAccessToken(session, wxPublicId);
            return wxApiHandler.deleteMenu(accessToken);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping
    @ResponseBody
    public String get(Integer wxPublicId, HttpSession session){

        try {
            checkParam(session, wxPublicId);
            String accessToken = getAccessToken(session, wxPublicId);
            return wxApiHandler.getMenu(accessToken);
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
