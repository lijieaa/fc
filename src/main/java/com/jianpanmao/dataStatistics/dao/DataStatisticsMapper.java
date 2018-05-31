package com.jianpanmao.dataStatistics.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by mayn on 2018/5/30.
 */
@Mapper
public interface DataStatisticsMapper {
    List<Map> intermediaryDeviceCount();
    List<Map> intermediaryArea();
    List<Map> deviceArea();


}
