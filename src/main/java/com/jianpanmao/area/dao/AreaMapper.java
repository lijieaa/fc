package com.jianpanmao.area.dao;

import com.jianpanmao.area.dto.AreaDto;
import com.jianpanmao.area.entity.Area;
import com.jianpanmao.area.entity.AreaExample;
import com.jianpanmao.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper extends BaseDao<Area, AreaExample, AreaDto, Integer> {


    List<Area> findByLP(@Param("level") Integer level, @Param("parent") Integer parent);

    List<Area> findByShortName(String shortName);

}