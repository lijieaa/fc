package com.we.fc.role.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.role.dao.RoleDao;
import com.we.fc.role.entity.Role;
import com.we.fc.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public BaseDao<Role> getDao() {
        return this.dao;
    }
}
