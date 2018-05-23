package com.jianpanmao.wxuseropenid.controller;

import com.jianpanmao.wxuseropenid.service.WxUserOpenidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("wxuseropenid")
public class WxUserOpenidController {


@Autowired
WxUserOpenidService wxuseropenidService;

@PreAuthorize("hasAuthority('wxuseropenid:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "wxuseropenid/wxuseropenid_list";
}

@PreAuthorize("hasAuthority('wxuseropenid:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "wxuseropenid/wxuseropenid_add";
}

@PreAuthorize("hasAuthority('wxuseropenid:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxuseropenid/wxuseropenid_edit";
}

@PreAuthorize("hasAuthority('wxuseropenid:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxuseropenid/wxuseropenid_detail";
}
}
