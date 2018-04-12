package com.we.fc.intermediary.dao;


import com.we.fc.base.BaseDao;
import com.we.fc.intermediary.entity.Intermediary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntermediaryMapper extends BaseDao {
    List<Intermediary> queryPage(@Param("intermediaryName") String intermediaryName);
}