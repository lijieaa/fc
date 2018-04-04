package com.we.fc.dept.service;


import com.we.fc.base.BaseService;
import com.we.fc.dept.entity.Dept;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-01 13:47
 */
public interface DeptService extends BaseService<Dept> {

    List<Dept> findByCompanyId(Integer companyId);
}
