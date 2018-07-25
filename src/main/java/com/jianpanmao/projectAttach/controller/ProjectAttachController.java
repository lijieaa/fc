package com.jianpanmao.projectAttach.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mayn on 2018/7/25.
 */
@RestController
@RequestMapping("/api/pa")
public class ProjectAttachController {
    /**
     * 新增项目文件分类
     */
    @PostMapping("pType")
    public void pType(){

    }
}
