package com.jianpanmao.contacts.controller;

import com.jianpanmao.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("contacts")
public class ContactsController {


@Autowired
ContactsService contactsService;

@PreAuthorize("hasAuthority('contacts:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "contacts/contacts_list";
}

@PreAuthorize("hasAuthority('contacts:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "contacts/contacts_add";
}

@PreAuthorize("hasAuthority('contacts:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "contacts/contacts_edit";
}

@PreAuthorize("hasAuthority('contacts:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "contacts/contacts_detail";
}
}
