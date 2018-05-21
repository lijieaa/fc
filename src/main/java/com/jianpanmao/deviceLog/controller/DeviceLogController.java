package com.jianpanmao.deviceLog.controller;

import com.jianpanmao.deviceLog.service.DeviceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("devicelog")
public class DeviceLogController {


@Autowired
DeviceLogService devicelogService;

@PreAuthorize("hasAuthority('devicelog:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "devicelog/devicelog_list";
}

@PreAuthorize("hasAuthority('devicelog:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "devicelog/devicelog_add";
}

@PreAuthorize("hasAuthority('devicelog:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "devicelog/devicelog_edit";
}

@PreAuthorize("hasAuthority('devicelog:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "devicelog/devicelog_detail";
}
}
