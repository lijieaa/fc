package com.we.fc.base;

import java.util.List;

/**
 * 通用DAO接口
 * @author zdc
 * @since 2018-03-27 22:38
 */
public interface BaseDao<T> {

    void add(T t) throws Exception;

    void delete(Integer id) throws Exception;

    void update(T t) throws Exception;

    T findById(Integer id);

    List<T> findAll();

}
