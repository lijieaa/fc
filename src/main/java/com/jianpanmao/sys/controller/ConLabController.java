package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.ConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("conlab")
public class ConLabController {


@Autowired
ConLabService conlabService;

@PreAuthorize("hasAuthority('conlab:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "conlab/conlab_list";
}

@PreAuthorize("hasAuthority('conlab:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "conlab/conlab_add";
}

@PreAuthorize("hasAuthority('conlab:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "conlab/conlab_edit";
}

@PreAuthorize("hasAuthority('conlab:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "conlab/conlab_detail";
}
}
