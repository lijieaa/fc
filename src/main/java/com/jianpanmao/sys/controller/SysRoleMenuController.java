package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("sysrolemenu")
public class SysRoleMenuController {


@Autowired
SysRoleMenuService sysrolemenuService;

@PreAuthorize("hasAuthority('sysrolemenu:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "sysrolemenu/sysrolemenu_list";
}

@PreAuthorize("hasAuthority('sysrolemenu:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "sysrolemenu/sysrolemenu_add";
}

@PreAuthorize("hasAuthority('sysrolemenu:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysrolemenu/sysrolemenu_edit";
}

@PreAuthorize("hasAuthority('sysrolemenu:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysrolemenu/sysrolemenu_detail";
}
}
