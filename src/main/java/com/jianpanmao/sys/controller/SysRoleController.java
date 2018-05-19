package com.jianpanmao.sys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.service.SysMenuService;
import com.jianpanmao.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("sysrole")
public class SysRoleController {


    @Autowired
    SysRoleService sysroleService;

    @Autowired
    SysMenuService sysMenuService;

    @PreAuthorize("hasAuthority('sysrole:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "sysrole/sysrole_list";
    }

    @PreAuthorize("hasAuthority('sysrole:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "sysrole/sysrole_add";
    }

    @PreAuthorize("hasAuthority('sysrole:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) throws JsonProcessingException {
        List<SysMenu> all = sysMenuService.getAll(null);
        model.addAttribute("id", id);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(all);
        model.addAttribute("json", json);
        return "sysrole/sysrole_edit";
    }

    @PreAuthorize("hasAuthority('sysrole:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "sysrole/sysrole_detail";
    }
}
