package com.jianpanmao.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommonController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
