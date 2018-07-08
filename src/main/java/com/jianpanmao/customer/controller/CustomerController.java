package com.jianpanmao.customer.controller;

import com.jianpanmao.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("customer")
public class CustomerController {


@Autowired
CustomerService customerService;

@PreAuthorize("hasAuthority('customer:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "customer/customer_list";
}

@PreAuthorize("hasAuthority('customer:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "customer/customer_add";
}

@PreAuthorize("hasAuthority('customer:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "customer/customer_edit";
}

@PreAuthorize("hasAuthority('customer:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "customer/customer_detail";
}
}
