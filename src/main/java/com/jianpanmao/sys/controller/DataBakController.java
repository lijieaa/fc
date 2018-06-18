package com.jianpanmao.sys.controller;

import com.jianpanmao.sys.service.ConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("databak")
public class DataBakController {


    @PreAuthorize("hasAuthority('databak:view')")
    @RequestMapping(method = RequestMethod.GET, value = "index")
    public String list() {
        return "databak/index";
    }
}
