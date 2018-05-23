package com.jianpanmao.wxmaterial.controller;

import com.jianpanmao.wxmaterial.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("wxmaterial")
public class WxMaterialController {


@Autowired
WxMaterialService wxmaterialService;

@PreAuthorize("hasAuthority('wxmaterial:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "wxmaterial/wxmaterial_list";
}

@PreAuthorize("hasAuthority('wxmaterial:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "wxmaterial/wxmaterial_add";
}

@PreAuthorize("hasAuthority('wxmaterial:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxmaterial/wxmaterial_edit";
}

@PreAuthorize("hasAuthority('wxmaterial:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "wxmaterial/wxmaterial_detail";
}
}
