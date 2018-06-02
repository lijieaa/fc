package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("sysuserrole")
public class SysUserRoleController {


@Autowired
SysUserRoleService sysuserroleService;

@PreAuthorize("hasAuthority('sysuserrole:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "sysuserrole/sysuserrole_list";
}

@PreAuthorize("hasAuthority('sysuserrole:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "sysuserrole/sysuserrole_add";
}

@PreAuthorize("hasAuthority('sysuserrole:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysuserrole/sysuserrole_edit";
}

@PreAuthorize("hasAuthority('sysuserrole:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysuserrole/sysuserrole_detail";
}
}
