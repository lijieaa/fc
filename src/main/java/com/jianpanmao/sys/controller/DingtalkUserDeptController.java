package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.DingtalkUserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("dingtalkuserdept")
public class DingtalkUserDeptController {


@Autowired
DingtalkUserDeptService dingtalkuserdeptService;

@PreAuthorize("hasAuthority('dingtalkuserdept:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "dingtalkuserdept/dingtalkuserdept_list";
}

@PreAuthorize("hasAuthority('dingtalkuserdept:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "dingtalkuserdept/dingtalkuserdept_add";
}

@PreAuthorize("hasAuthority('dingtalkuserdept:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "dingtalkuserdept/dingtalkuserdept_edit";
}

@PreAuthorize("hasAuthority('dingtalkuserdept:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "dingtalkuserdept/dingtalkuserdept_detail";
}
}
