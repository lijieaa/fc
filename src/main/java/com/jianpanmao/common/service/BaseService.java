package com.jianpanmao.common.service;


import com.jianpanmao.exception.CustomException;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, E, D,PK extends Serializable>{
    long countByExample(E example);

    int removeByExample(E example);

    int removeBatch(PK ids[]);

    int remove(PK TId);

    List<T> getAll(T record);

    int add(T record);

    int addSelective(T record);

    List<T> getByExampleWithBLOBs(E example);

    List<T> getByExample(E example);

    T get(PK TId);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int update(T record);

    List<T> getByDto(D dto);
}
