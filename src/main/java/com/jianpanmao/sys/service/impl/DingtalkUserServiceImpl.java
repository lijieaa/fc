package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.DingtalkUserDeptService;
import com.jianpanmao.sys.service.DingtalkUserService;
import com.jianpanmao.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingtalkUserServiceImpl extends BaseServiceImpl<DingtalkUser,DingtalkUserExample,DingtalkUserDto,Integer> implements DingtalkUserService {

    @Autowired
    DingtalkUserMapper dingtalkUserMapper;

    @Override
    public DingtalkUser findByMobile(String mobile) {
        return dingtalkUserMapper.findByMobile(mobile);
    }

    @Override
    public List<DingtalkUser> selectByDeptId(Integer deptId) {
        return dingtalkUserMapper.selectByDeptId(deptId);
    }

    @Override
    public List<DingtalkUser> selectByLikeName(String name) {

        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        DingtalkUser user=new DingtalkUser();
        user.setName(name);
        user.setIntermediaryId(cuser.getIntermediaryId());
        return dingtalkUserMapper.selectByLikeName(user);
    }

    @Override
    public List<DingtalkUser> selectByRoleId(Integer roleId) {
        return dingtalkUserMapper.selectByRoleId(roleId);
    }

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    SysUserRoleService userRoleService;


    @Autowired
    DingtalkUserDeptService userDeptService;



    @Override
    public int add(DingtalkUser record) {

        String password = record.getPassword();

        String encode = passwordEncoder.encode(password);

        record.setPassword(encode);

        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        record.setIntermediaryId(cuser.getIntermediaryId());


        int add = super.add(record);

        List<SysRole> roles = record.getRoles();

        for (SysRole role : roles) {
            userRoleService.add(new SysUserRole(record.getUserid(),role.getRoleId()));
        }


        List<DingtalkDept> depts = record.getDepts();

        for (DingtalkDept dept : depts) {
            userDeptService.add(new DingtalkUserDept(record.getUserid(),dept.getId()));
        }

        return add;
    }
}