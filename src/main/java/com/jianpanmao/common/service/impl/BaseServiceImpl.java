package com.jianpanmao.common.service.impl;


import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.common.service.BaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public abstract class BaseServiceImpl<T, E, D,PK extends Serializable> implements BaseService<T, E,D, PK>{

    @Autowired
    private BaseDao<T, E, D,PK> dao;

    @Override
    public long countByExample(E example) {
        return dao.countByExample(example);
    }

    @Override
    public int removeByExample(E example) {
        return dao.deleteByExample(example);
    }

    @Override
    public int removeBatch(PK[] ids) {

        return dao.deleteBatch(ids);
    }

    @Override
    public int remove(PK TId) {
        return dao.deleteByPrimaryKey(TId);
    }

    @Override
    public List<T> getAll(T record) {
        return dao.selectAll(record);
    }

    @Override
    public int add(T record) {
        return dao.insert(record);
    }

    @Override
    public int addSelective(T record) {
        return dao.insertSelective(record);
    }

    @Override
    public List<T> getByExampleWithBLOBs(E example) {
        return dao.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<T> getByExample(E example) {
        return dao.selectByExample(example);
    }

    @Override
    public T get(PK TId) {
        return dao.selectByPrimaryKey(TId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") T record, @Param("example") E example) {
        return dao.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example) {
        return dao.updateByExampleWithBLOBs(record,example);
    }

    @Override
    public int updateByExample(@Param("record") T record, @Param("example") E example) {
        return dao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return dao.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int update(T record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public List<T> getByDto(D dto) {
        return dao.selectByDto(dto);
    }

}
