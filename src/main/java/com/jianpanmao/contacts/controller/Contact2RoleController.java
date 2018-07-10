package com.jianpanmao.contacts.controller;

import com.jianpanmao.contacts.service.Contact2RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("contact2role")
public class Contact2RoleController {


@Autowired
Contact2RoleService contact2roleService;

@PreAuthorize("hasAuthority('contact2role:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "contact2role/contact2role_list";
}

@PreAuthorize("hasAuthority('contact2role:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "contact2role/contact2role_add";
}

@PreAuthorize("hasAuthority('contact2role:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "contact2role/contact2role_edit";
}

@PreAuthorize("hasAuthority('contact2role:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "contact2role/contact2role_detail";
}
}
