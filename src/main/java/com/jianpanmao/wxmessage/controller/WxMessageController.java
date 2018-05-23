package com.jianpanmao.wxmessage.controller;

import com.jianpanmao.wxmessage.service.WxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("wxmessage")
public class WxMessageController {


@Autowired
WxMessageService wxmessageService;

@PreAuthorize("hasAuthority('wxmessage:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "wxmessage/wxmessage_list";
}

@PreAuthorize("hasAuthority('wxmessage:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "wxmessage/wxmessage_add";
}

@PreAuthorize("hasAuthority('wxmessage:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxmessage/wxmessage_edit";
}

@PreAuthorize("hasAuthority('wxmessage:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxmessage/wxmessage_detail";
}
}
