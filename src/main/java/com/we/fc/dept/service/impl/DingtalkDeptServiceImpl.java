package com.we.fc.dept.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.dept.dao.DingtalkDeptMapper;
import com.we.fc.dept.entity.DingtalkDept;
import com.we.fc.dept.service.DingtalkDeptService;
import com.we.fc.user.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int insert(DingtalkDept dingtalkDept) throws Exception {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        dingtalkDept.setIntermediaryId(intermediaryId);
        int insert = super.insert(dingtalkDept);
        dingtalkDept.setPath(dingtalkDept.getPath()+","+dingtalkDept.getId());
        dingtalkDeptMapper.updatePath(dingtalkDept);
        return insert;
    }

    @Override
    public void updateByPrimaryKey(DingtalkDept dingtalkDept) throws Exception {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        dingtalkDept.setIntermediaryId(intermediaryId);
        super.updateByPrimaryKey(dingtalkDept);
    }

    @Override
    public List<DingtalkDept> findByParentId(Integer id) {
        return dingtalkDeptMapper.findByParentId(id);
    }
}