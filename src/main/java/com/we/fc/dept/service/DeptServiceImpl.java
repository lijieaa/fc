package com.we.fc.dept.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.dept.dao.DeptDao;
import com.we.fc.dept.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-01 13:47
 */
@Service
@Transactional
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired private DeptDao deptDao;

    @Override
    public BaseDao<Dept> getDao() {
        return deptDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dept> findByCompanyId(Integer companyId) {
        return deptDao.findByCompanyId(companyId);
    }
}
