package com.we.fc.base;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:43
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getDao();

    @Override
    public void add(T t) throws Exception {
        getDao().add(t);
    }

    @Override
    public void delete(Integer id) throws Exception {
        getDao().delete(id);
    }

    @Override
    public void update(T t) throws Exception {
        getDao().update(t);
    }

    @Override
    public T findById(Integer id) {
        return getDao().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }
}
