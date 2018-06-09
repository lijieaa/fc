package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.ExtConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("extcon")
public class ExtConController {


@Autowired
ExtConService extconService;

@PreAuthorize("hasAuthority('extcon:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "extcon/extcon_list";
}

@PreAuthorize("hasAuthority('extcon:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "extcon/extcon_add";
}

@PreAuthorize("hasAuthority('extcon:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "extcon/extcon_edit";
}

@PreAuthorize("hasAuthority('extcon:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "extcon/extcon_detail";
}
}
