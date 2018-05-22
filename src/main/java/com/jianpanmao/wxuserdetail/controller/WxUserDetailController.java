package com.jianpanmao.wxuserdetail.controller;

import com.jianpanmao.wxuserdetail.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("wxuserdetail")
public class WxUserDetailController {


@Autowired
WxUserDetailService wxuserdetailService;

@PreAuthorize("hasAuthority('wxuserdetail:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "wxuserdetail/wxuserdetail_list";
}

@PreAuthorize("hasAuthority('wxuserdetail:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "wxuserdetail/wxuserdetail_add";
}

@PreAuthorize("hasAuthority('wxuserdetail:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxuserdetail/wxuserdetail_edit";
}

@PreAuthorize("hasAuthority('wxuserdetail:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxuserdetail/wxuserdetail_detail";
}
}
