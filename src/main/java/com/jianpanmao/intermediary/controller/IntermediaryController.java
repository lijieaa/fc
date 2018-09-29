package com.jianpanmao.intermediary.controller;

import com.jianpanmao.intermediary.service.IntermediaryService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("intermediary")
public class IntermediaryController {


    @Autowired
    IntermediaryService intermediaryService;

    @PreAuthorize("hasAuthority('intermediary:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "intermediary/intermediary_list";
    }

    @PreAuthorize("hasAuthority('intermediary:add')")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add() {
        return "intermediary/intermediary_add";
    }

    @PreAuthorize("hasAuthority('intermediary:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "intermediary/intermediary_edit";
    }

    @PreAuthorize("hasAuthority('intermediary:edit')")
    @RequestMapping(method = RequestMethod.GET, value = "info")
    public String editInfo(Model model) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        model.addAttribute("id", intermediaryId);
        //model.addAttribute("id", id);
        return "intermediary/intermediary_info";
    }

    @PreAuthorize("hasAuthority('intermediary:view')")
    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "intermediary/intermediary_detail";
    }
}
