package com.jianpanmao.dataStatistics.controller;

import com.jianpanmao.dataStatistics.dao.DataStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @GetMapping("/intermediaryArea")
    public List<Map> intermediaryArea(){
        return dao.intermediaryArea();
    }
    @GetMapping("/deviceArea")
    public List<Map> deviceArea(){
        return dao.deviceArea();
    }
    @GetMapping("/fiveYearDicount")
    public Map<String,List<Map>> fiveYearDicount(){
        Map<String,List<Map>> map = new HashMap<>();
        List<Map> iMap = dao.intermediary();
        List<Map> dMap = dao.device();
        map.put("intermediary",iMap);
        map.put("device",dMap);
        return map;
    }
}
