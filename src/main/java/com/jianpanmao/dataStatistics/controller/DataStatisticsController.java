package com.jianpanmao.dataStatistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mayn on 2018/6/2.
 * 数据统计
 */

@Controller
@RequestMapping("dataStatistics")
public class DataStatisticsController {

    @GetMapping("all")
    public String all(){
        return "dataStatistics/all";
    }
}
