package com.we.fc.base;

import java.util.List;

/**
 * 通用DAO接口
 * @author zdc
 * @since 2018-03-27 22:38
 */
public interface BaseDao<T> {

    void insert(T t) throws Exception;

    void deleteByPrimaryKey(Integer id) throws Exception;

    void updateByPrimaryKey(T t) throws Exception;

    T selectByPrimaryKey(Integer id);

    List<T> selectAll(T t);

}
