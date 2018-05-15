package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 公从号Controller
 * @author zdc
 * @since 2018-04-13 21:41
 */
@Controller
@RequestMapping("wxPublic")
public class WxPublicController extends BaseController<WxPublic>{

    @Autowired private WxPublicService wxPublicService;

    @Autowired private WxApiHandler wxApiHandler;

    @Override
    public BaseService<WxPublic> getService() {
        return wxPublicService;
    }

    @Override
    protected ResponseEntity hookExist(WxPublic wxPublic) {
        return null;
    }

    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "wechat/index";
    }

    @GetMapping("menu")
    public String menu(Integer menuId, Integer wxPublicId,Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/menu";
    }

    @GetMapping("user")
    public String user(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/user";
    }

    @GetMapping("msg")
    public String msg(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/msg";
    }

    @GetMapping("material")
    public String material(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/material";
    }

    @Override
    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody WxPublic wxPublic, BindingResult result, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        } catch (Exception e) {
            responseEntity.setMessages("appId或appSecret错误！");
            responseEntity.setStatus("500");
            return responseEntity;
        }
        wxPublic.setIntermediary(getSelf(session).getIntermediary());
        return super.add(wxPublic, result, session);
    }

    @Override
    @PutMapping
    @ResponseBody
    public ResponseEntity update(@RequestBody WxPublic wxPublic, BindingResult result, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        } catch (Exception e) {
            responseEntity.setMessages("appId或appSecret错误！");
            responseEntity.setStatus("500");
            return responseEntity;
        }
        wxPublic.setIntermediary(getSelf(session).getIntermediary());
        return super.update(wxPublic, result, session);
    }

    @Override
    @DeleteMapping
    @ResponseBody
    public ResponseEntity delete(Integer id, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        Intermediary intermediary = getSelf(session).getIntermediary();
        List<WxPublic> wxPublics = wxPublicService.findByCompanyId(intermediary.getId());
        List<Integer> ids = new ArrayList<>();
        for(WxPublic wxPublic : wxPublics){
            ids.add(wxPublic.getId());
        }
        if(!ids.contains(id)){
            responseEntity.setMessages("没有权限删除该公众号");
            responseEntity.setStatus("500");
            return responseEntity;
        }
        return super.delete(id, session);
    }
}
