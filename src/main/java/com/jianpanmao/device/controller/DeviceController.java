package com.jianpanmao.device.controller;

import com.jianpanmao.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("device")
public class DeviceController {


@Autowired
DeviceService deviceService;

@PreAuthorize("hasAuthority('device:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "device/device_list";
}

@PreAuthorize("hasAuthority('device:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "device/device_add";
}

@PreAuthorize("hasAuthority('device:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "device/device_edit";
}

@PreAuthorize("hasAuthority('device:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "device/device_detail";
}
}
