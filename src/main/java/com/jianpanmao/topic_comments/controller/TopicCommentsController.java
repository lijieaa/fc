package com.jianpanmao.topic_comments.controller;

import com.jianpanmao.topic_comments.service.TopicCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("topiccomments")
public class TopicCommentsController {


@Autowired
TopicCommentsService topiccommentsService;

@PreAuthorize("hasAuthority('topiccomments:view')")
@RequestMapping(method = RequestMethod.GET,value = "list")
public String list(){
return "topiccomments/topiccomments_list";
}

@PreAuthorize("hasAuthority('topiccomments:add')")
@RequestMapping(method = RequestMethod.GET,value = "add")
public String add(){
return "topiccomments/topiccomments_add";
}

@PreAuthorize("hasAuthority('topiccomments:edit')")
@RequestMapping(method = RequestMethod.GET,value = "edit")
public String edit(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "topiccomments/topiccomments_edit";
}

@PreAuthorize("hasAuthority('topiccomments:view')")
@RequestMapping(method = RequestMethod.GET,value = "detail")
public String detail(@RequestParam("id") Integer id, Model model){
model.addAttribute("id",id);
return "topiccomments/topiccomments_detail";
}
}
