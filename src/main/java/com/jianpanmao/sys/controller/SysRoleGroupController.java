package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.SysRoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("sysrolegroup")
public class SysRoleGroupController {


@Autowired
SysRoleGroupService sysrolegroupService;

@PreAuthorize("hasAuthority('sysrolegroup:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "sysrolegroup/sysrolegroup_list";
}

@PreAuthorize("hasAuthority('sysrolegroup:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "sysrolegroup/sysrolegroup_add";
}

@PreAuthorize("hasAuthority('sysrolegroup:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysrolegroup/sysrolegroup_edit";
}

@PreAuthorize("hasAuthority('sysrolegroup:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "sysrolegroup/sysrolegroup_detail";
}
}
