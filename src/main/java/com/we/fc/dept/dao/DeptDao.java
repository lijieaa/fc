package com.we.fc.dept.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.dept.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 14:45
 */
@Mapper
public interface DeptDao extends BaseDao<Dept> {

    List<Dept> findByCompanyId(Integer companyId);

    List<Dept> findChildren(Integer id);
}
