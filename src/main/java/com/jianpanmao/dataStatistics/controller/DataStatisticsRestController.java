package com.jianpanmao.dataStatistics.controller;

import com.jianpanmao.dataStatistics.dao.DataStatisticsMapper;
import com.jianpanmao.dataStatistics.dto.DataStatisticsDto;
import com.jianpanmao.dataStatistics.dto.DataStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mayn on 2018/5/30.
 * 数据统计
 */
@RestController
@RequestMapping("/api/dataStatistics")
public class DataStatisticsRestController {
    @Autowired
    DataStatisticsMapper dao;

    @PreAuthorize("hasAuthority('dataStatistics:view')")
    @GetMapping("/intermediaryDeviceCount")
    public List<Map> intermediaryDeviceCount() {
        return dao.intermediaryDeviceCount();
    }

    @PreAuthorize("hasAuthority('dataStatistics:view')")
    @GetMapping("/intermediaryArea")
    public List<Map> intermediaryArea() {
        return dao.intermediaryArea();
    }

    @PreAuthorize("hasAuthority('dataStatistics:view')")
    @GetMapping("/projectArea")
    public List<Map> projectArea() {
        return dao.projectArea();
    }

    @PreAuthorize("hasAuthority('dataStatistics:view')")
    @GetMapping("/fiveYearDicount")
    public List<DataStatisticsVo> fiveYearDicount() {
        List<DataStatisticsVo> vos = new ArrayList<>();
        List<DataStatisticsDto> ins = dao.intermediary();
        List<DataStatisticsDto> des = dao.device();
        Map<Integer,Integer> im = new HashMap<>();
        for (DataStatisticsDto i:ins){
            im.put(i.getYear(),i.getCount());
        }
        Map<Integer,Integer> dm = new HashMap<>();
        for (DataStatisticsDto d:des){
            dm.put(d.getYear(),d.getCount());
        }
        DateFormat f = new SimpleDateFormat("yyyy");
        Integer year = Integer.valueOf(f.format(new Date()));
        for (int i = year-4; i <=year ; i++) {
            DataStatisticsVo v = new DataStatisticsVo();
            v.setYear(i);
            if (null!=im.get(i)){
                v.setiCount(im.get(i));
            }else {
                v.setiCount(0);
            }
            if (null!=dm.get(i)){
                v.setdCount(dm.get(i));
            }else {
                v.setdCount(0);
            }
            vos.add(v);
        }

        return vos;
    }
}
