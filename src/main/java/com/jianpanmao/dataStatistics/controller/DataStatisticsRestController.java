package com.jianpanmao.dataStatistics.controller;

import com.jianpanmao.dataStatistics.dao.DataStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by mayn on 2018/5/30.
 * 数据统计
 */
@RestController
@RequestMapping("/api/dataStatistics")
public class DataStatisticsRestController {
    @Autowired
    DataStatisticsMapper dao;

    @GetMapping("/intermediaryDeviceCount")
        public List<Map> intermediaryDeviceCount(){
        return dao.intermediaryDeviceCount();
    }
}
