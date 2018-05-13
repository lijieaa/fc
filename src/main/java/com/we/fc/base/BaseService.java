package com.we.fc.base;


import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:42
 */
public interface BaseService<T> {

    int insert(T t) throws Exception;

    void deleteByPrimaryKey(Integer id) throws Exception;

    void updateByPrimaryKey(T t) throws Exception;

    T selectByPrimaryKey(Integer id);

    List<T> selectAll(T t);

    Integer exist(String name,String value);
}
