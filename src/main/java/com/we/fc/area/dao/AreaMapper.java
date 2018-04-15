package com.we.fc.area.dao;


import com.we.fc.area.entity.Area;
import com.we.fc.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper extends BaseDao<Area> {

    List<Area> findByLP(@Param("level") Integer level, @Param("parent") Integer parent);
}