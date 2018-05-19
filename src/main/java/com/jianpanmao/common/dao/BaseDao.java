package com.jianpanmao.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface BaseDao<T, E, D,PK extends Serializable> {

    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(PK TId);

    int deleteBatch(PK ids[]);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(E example);

    List<T> selectByExample(E example);

    List<T> selectAll(T record);

    T selectByPrimaryKey(PK TId);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);


    List<T> selectByDto(D dto);
}
