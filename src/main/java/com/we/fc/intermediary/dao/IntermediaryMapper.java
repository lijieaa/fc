package com.we.fc.intermediary.dao;


import com.we.fc.base.BaseDao;
import com.we.fc.intermediary.entity.Intermediary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntermediaryMapper extends BaseDao {

    List<Intermediary> queryPage(@Param("name") String name, @Param("area") String area, @Param("contact") String contact, @Param("tel") String tel);

    List<Intermediary> selectIdNameList();

}