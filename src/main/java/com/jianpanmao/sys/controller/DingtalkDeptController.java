package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.DingtalkDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("dingtalkdept")
public class DingtalkDeptController {


@Autowired
DingtalkDeptService dingtalkdeptService;

@PreAuthorize("hasAuthority('dingtalkdept:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "dingtalkdept/dingtalkdept_list";
}

@PreAuthorize("hasAuthority('dingtalkdept:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "dingtalkdept/dingtalkdept_add";
}

@PreAuthorize("hasAuthority('dingtalkdept:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "dingtalkdept/dingtalkdept_edit";
}

@PreAuthorize("hasAuthority('dingtalkdept:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "dingtalkdept/dingtalkdept_detail";
}
}
