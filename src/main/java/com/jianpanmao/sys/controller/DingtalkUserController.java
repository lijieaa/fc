package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.dao.DingtalkDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("dingtalkuser")
public class DingtalkUserController {


    @Autowired
    DingtalkUserService dingtalkuserService;



    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "dingtalkuser/dingtalkuser_list";
    }

    @PreAuthorize("hasAuthority('dingtalkuser:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "dingtalkuser/dingtalkuser_add";
    }

    @PreAuthorize("hasAuthority('dingtalkuser:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "dingtalkuser/dingtalkuser_edit";
    }

    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "dingtalkuser/dingtalkuser_detail";
    }


}
