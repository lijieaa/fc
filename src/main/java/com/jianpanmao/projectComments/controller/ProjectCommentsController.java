package com.jianpanmao.projectComments.controller;

import com.jianpanmao.projectComments.service.ProjectCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("projectcomments")
public class ProjectCommentsController {


@Autowired
ProjectCommentsService projectcommentsService;

@PreAuthorize("hasAuthority('projectcomments:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "projectcomments/projectcomments_list";
}

@PreAuthorize("hasAuthority('projectcomments:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "projectcomments/projectcomments_add";
}

@PreAuthorize("hasAuthority('projectcomments:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "projectcomments/projectcomments_edit";
}

@PreAuthorize("hasAuthority('projectcomments:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "projectcomments/projectcomments_detail";
}
}
