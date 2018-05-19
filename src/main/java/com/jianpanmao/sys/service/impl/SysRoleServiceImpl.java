package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.SysRoleMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,SysRoleExample,SysRoleDto,Integer> implements SysRoleService {

    @Autowired
    SysRoleMapper roleMapper;

    @Override
    public int add(SysRole record) {
        int add = super.add(record);
        for (SysMenu menu : record.getMenus()) {
            roleMapper.insertRM(record.getRoleId(),menu.getMenuId());
        }
        return add;
    }

}