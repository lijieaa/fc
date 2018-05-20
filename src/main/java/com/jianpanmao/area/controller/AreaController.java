package com.jianpanmao.area.controller;

import com.jianpanmao.area.dao.AreaMapper;
import com.jianpanmao.area.entity.Area;
import com.jianpanmao.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @Autowired
    AreaMapper dao;

    @GetMapping("condition")
    @ResponseBody
    public List<Area> findByLP(@RequestParam Integer level, @RequestParam(required = false) Integer parent) {
        List<Area> areas = dao.findByLP(level, parent);
        if (level.intValue() == 1) {
            for (Area area : areas) {
                area.setParent(true);
            }
        }
        return areas;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Area> findByShortName(String shortName){
        List<Area> areas = dao.findByShortName(shortName);
        return areas;
    }
}
