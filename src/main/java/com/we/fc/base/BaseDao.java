package com.we.fc.base;

import com.we.fc.intermediary.entity.Intermediary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通用DAO接口
 *
 * @author zdc
 * @since 2018-03-27 22:38
 */
public interface BaseDao<T> {

    int insert(T t) throws Exception;

    void deleteByPrimaryKey(Integer id) throws Exception;

    void updateByPrimaryKey(T t) throws Exception;

    T selectByPrimaryKey(Integer id);

    List<T> selectAll(T t);

    Integer exist(@Param("name") String name, @Param("value") String value);

}
