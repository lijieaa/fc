package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.SysRoleMapper;
import com.jianpanmao.sys.dao.SysUserRoleMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.SysRoleMenuService;
import com.jianpanmao.sys.service.SysRoleService;
import com.jianpanmao.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,SysRoleExample,SysRoleDto,Integer> implements SysRoleService {

    @Autowired
    SysRoleMapper roleMapper;

    @Autowired
    SysUserRoleMapper userRoleMapper;




    @Autowired
    SysRoleMenuService sysRoleMenuService;


    @Autowired
    SysUserRoleService sysUserRoleService;


    @Override
    public int remove(Integer TId) {
        int remove = super.remove(TId);
        sysRoleMenuService.remove(TId);
        sysUserRoleService.remove(TId);
        return remove;
    }

    @Override
    public int add(SysRole record) {
        DingtalkUser addUser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        record.setIntermediaryId(addUser.getIntermediaryId());
        int add = super.add(record);
        for (SysMenu menu : record.getMenus()) {
            roleMapper.insertRM(record.getRoleId(),menu.getMenuId());
        }
        return add;
    }
    @Override
    public int update(SysRole record) {
        sysRoleMenuService.remove(record.getRoleId());
        for (SysMenu menu : record.getMenus()) {
            roleMapper.insertRM(record.getRoleId(),menu.getMenuId());
        }
        return super.update(record);
    }

    @Override
    public int unbindUser(Integer userId) {
        return userRoleMapper.deleteByUserId(userId);
    }

    @Override
    public int deleteByGroupId(Integer gid) {
        return roleMapper.deleteByGroupId(gid);
    }
}