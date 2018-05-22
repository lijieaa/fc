package com.jianpanmao.wxpublic.controller;

import com.jianpanmao.wxpublic.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("wxpublic")
public class WxPublicController {


    @Autowired
    WxPublicService wxpublicService;

    @PreAuthorize("hasAuthority('wxpublic:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "wxpublic/wxpublic_list";
    }

    @PreAuthorize("hasAuthority('wxpublic:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "wxpublic/wxpublic_add";
    }

    @PreAuthorize("hasAuthority('wxpublic:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "wxpublic/wxpublic_edit";
    }

    @PreAuthorize("hasAuthority('wxpublic:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "wxpublic/wxpublic_detail";
    }
}
