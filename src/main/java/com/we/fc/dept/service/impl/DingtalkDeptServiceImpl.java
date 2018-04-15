package com.we.fc.dept.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.dept.dao.DingtalkDeptMapper;
import com.we.fc.dept.entity.DingtalkDept;
import com.we.fc.dept.service.DingtalkDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模拟钉钉部门
 */
@Service
public class DingtalkDeptServiceImpl extends BaseServiceImpl<DingtalkDept> implements DingtalkDeptService{

    private  DingtalkDeptMapper dingtalkDeptMapper;

    @Autowired
    public DingtalkDeptServiceImpl(DingtalkDeptMapper dingtalkDeptMapper) {
        this.dingtalkDeptMapper=dingtalkDeptMapper;
    }

    @Override
    public BaseDao<DingtalkDept> getDao() {
        return dingtalkDeptMapper;
    }
}