package com.jianpanmao.sys.controller;

import com.jianpanmao.common.utils.MenuUtil;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("sysmenu")
public class SysMenuController {


    @Autowired
    SysMenuService sysmenuService;

    @PreAuthorize("hasAuthority('sysmenu:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list(Model model) {
        List<SysMenu> menus = sysmenuService.getAll(null);

        model.addAttribute("menus",MenuUtil.buildByRecursive(menus));
        return "sysmenu/sysmenu_list";
    }

    @PreAuthorize("hasAuthority('sysmenu:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "sysmenu/sysmenu_add";
    }

    @PreAuthorize("hasAuthority('sysmenu:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "sysmenu/sysmenu_edit";
    }

    @PreAuthorize("hasAuthority('sysmenu:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "sysmenu/sysmenu_detail";
    }
}
