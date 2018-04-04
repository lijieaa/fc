package com.we.fc.base;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:42
 */
public interface BaseService<T> {

    void add(T t) throws Exception;

    void delete(Integer id) throws Exception;

    void update(T t) throws Exception;

    T findById(Integer id);

    List<T> findAll();
}
