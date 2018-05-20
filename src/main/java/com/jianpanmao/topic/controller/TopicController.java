package com.jianpanmao.topic.controller;

import com.jianpanmao.topic.dao.TopicMapper;
import com.jianpanmao.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("topic")
public class TopicController {


    @Autowired
    TopicService topicService;




    @PreAuthorize("hasAuthority('topic:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "topic/topic_list";
    }

    @PreAuthorize("hasAuthority('topic:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "topic/topic_add";
    }

    @PreAuthorize("hasAuthority('topic:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "topic/topic_edit";
    }

    @PreAuthorize("hasAuthority('topic:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "topic/topic_detail";
    }

}

