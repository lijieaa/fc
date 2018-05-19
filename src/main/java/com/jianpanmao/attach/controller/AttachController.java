package com.jianpanmao.attach.controller;

import com.jianpanmao.attach.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("attach")
public class AttachController {


@Autowired
AttachService attachService;

@PreAuthorize("hasAuthority('attach:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "attach/attach_list";
}

@PreAuthorize("hasAuthority('attach:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "attach/attach_add";
}

@PreAuthorize("hasAuthority('attach:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "attach/attach_edit";
}

@PreAuthorize("hasAuthority('attach:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "attach/attach_detail";
}
}
