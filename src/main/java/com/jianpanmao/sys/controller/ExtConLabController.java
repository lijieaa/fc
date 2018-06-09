package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.ExtConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("extconlab")
public class ExtConLabController {


@Autowired
ExtConLabService extconlabService;

@PreAuthorize("hasAuthority('extconlab:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "extconlab/extconlab_list";
}

@PreAuthorize("hasAuthority('extconlab:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "extconlab/extconlab_add";
}

@PreAuthorize("hasAuthority('extconlab:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "extconlab/extconlab_edit";
}

@PreAuthorize("hasAuthority('extconlab:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "extconlab/extconlab_detail";
}
}
