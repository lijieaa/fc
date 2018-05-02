package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 公从号Controller
 * @author zdc
 * @since 2018-04-13 21:41
 */
@Controller
@RequestMapping("wxPublic")
public class WxPublicController extends BaseController<WxPublic>{

    @Autowired private WxPublicService wxPublicService;

    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "wechat/index";
    }

    @Override
    public BaseService<WxPublic> getService() {
        return wxPublicService;
    }

    @Override
    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody WxPublic wxPublic, BindingResult result, HttpSession session) {
        wxPublic.setIntermediary(getSelf(session).getIntermediary());
        return super.add(wxPublic, result, session);
    }
}
