package com.jianpanmao.area.dao;

import com.jianpanmao.area.dto.AreaDto;
import com.jianpanmao.area.entity.Area;
import com.jianpanmao.area.entity.AreaExample;
import com.jianpanmao.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AreaMapper extends BaseDao<Area, AreaExample, AreaDto, Integer> {
}