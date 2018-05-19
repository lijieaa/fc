package com.jianpanmao.codegen.dao;

import com.jianpanmao.codegen.entity.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeGenMapper{

    List<Table> selectAll();
}