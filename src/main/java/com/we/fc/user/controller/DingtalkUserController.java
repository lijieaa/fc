package com.we.fc.user.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.user.entity.DingtalkUser;
import com.we.fc.user.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户controller
 */
@Controller
@RequestMapping("dingtalk_user")
public class DingtalkUserController extends BaseController<DingtalkUser>{

    private DingtalkUserService dingtalkUserService;

    @Autowired
    public DingtalkUserController(DingtalkUserService dingtalkUserService) {
        this.dingtalkUserService=dingtalkUserService;
    }

    @Override
    public BaseService<DingtalkUser> getService() {
        return dingtalkUserService;
    }


    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "sys/user/index";
    }
}
