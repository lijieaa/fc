package com.jianpanmao.project.controller;

import com.jianpanmao.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("clue")
public class ClueController {


@Autowired
ProjectService projectService;

@PreAuthorize("hasAuthority('project:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "clue/clue_list";
}

@PreAuthorize("hasAuthority('project:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "clue/clue_add";
}

@PreAuthorize("hasAuthority('project:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "clue/clue_edit";
}

@PreAuthorize("hasAuthority('project:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "clue/clue_detail";
}
}
