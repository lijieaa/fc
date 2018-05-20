package com.jianpanmao.area.controller;

import com.jianpanmao.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("area")
public class AreaController {


@Autowired
AreaService areaService;

@PreAuthorize("hasAuthority('area:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "area/area_list";
}

@PreAuthorize("hasAuthority('area:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "area/area_add";
}

@PreAuthorize("hasAuthority('area:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "area/area_edit";
}

@PreAuthorize("hasAuthority('area:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "area/area_detail";
}
}
