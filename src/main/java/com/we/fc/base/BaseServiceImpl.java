package com.we.fc.base;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:43
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getDao();

    @Override
    public int insert(T t) throws Exception {
        return getDao().insert(t);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) throws Exception {
        getDao().deleteByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKey(T t) throws Exception {
        getDao().updateByPrimaryKey(t);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll(T t) {
        return getDao().selectAll(t);
    }

    @Override
    public Integer exist(Integer id,String name, String value) {
        return getDao().exist(id,name, value);
    }
}
