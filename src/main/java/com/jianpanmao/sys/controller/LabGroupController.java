package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.LabGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("labgroup")
public class LabGroupController {


@Autowired
LabGroupService labgroupService;

@PreAuthorize("hasAuthority('labgroup:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "labgroup/labgroup_list";
}

@PreAuthorize("hasAuthority('labgroup:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "labgroup/labgroup_add";
}

@PreAuthorize("hasAuthority('labgroup:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "labgroup/labgroup_edit";
}

@PreAuthorize("hasAuthority('labgroup:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "labgroup/labgroup_detail";
}
}
