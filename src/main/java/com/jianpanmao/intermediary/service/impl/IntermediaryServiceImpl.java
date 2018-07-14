package com.jianpanmao.intermediary.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.exception.CustomException;
import com.jianpanmao.intermediary.dao.IntermediaryMapper;
import com.jianpanmao.intermediary.entity.*;
import com.jianpanmao.intermediary.dto.*;
import com.jianpanmao.intermediary.service.IntermediaryService;
import com.jianpanmao.sys.dao.DingtalkDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.dao.SysUserRoleMapper;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.DingtalkUserDept;
import com.jianpanmao.sys.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntermediaryServiceImpl extends BaseServiceImpl<Intermediary, IntermediaryExample, IntermediaryDto, Integer> implements IntermediaryService {

    @Autowired
    IntermediaryMapper intermediaryMapper;

    @Autowired
    DingtalkDeptMapper dingtalkDeptMapper;

    @Autowired
    DingtalkUserMapper dingtalkUserMapper;

    @Autowired
    DingtalkUserDeptMapper dingtalkUserDeptMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public int removeI(Integer TId) throws CustomException {
        Intermediary intermediary = super.get(TId);
        if (intermediary.getIsPlat().intValue() == 1) {
            throw new CustomException("该条数据不允许被删除");
        }
        return super.remove(TId);
    }

    @Override
    @Transactional
    public int removeBatchI(Integer[] ids) throws CustomException {
        for (Integer id : ids) {
            Intermediary intermediary = super.get(id);
            if (intermediary.getIsPlat().intValue() == 1) {
                throw new CustomException("该条数据不允许被删除");
            }
        }
        return super.removeBatch(ids);
    }

    @Override
    @Transactional
    public int add(Intermediary record) {
         super.add(record);
//添加部门和人
        addDeptAndUser(record);
        //添加平台联系人
        String fcUser = record.getFcUser();
        if (null != fcUser && fcUser.length() > 0) {
            List<IntermediaryUser> intermediaryUsers = new ArrayList<>();
            String[] fcUsers = record.getFcUser().split(",");
            for (String u : fcUsers) {
                IntermediaryUser intermediaryUser = new IntermediaryUser();
                intermediaryUser.setIntermediaryUserIid(record.getIntermediaryId());
                intermediaryUser.setIntermediaryUserUid(Integer.valueOf(u));
                intermediaryUser.setIntermediaryUserStatus(0);
                intermediaryUsers.add(intermediaryUser);
            }
            intermediaryMapper.addFcUser(intermediaryUsers);
        }
        return record.getIntermediaryId();
    }

    //添加中间商时添加默认部门和人
    public void addDeptAndUser(Intermediary intermediary) {
        //添加部门
        DingtalkDept dingtalkDept = new DingtalkDept();
        dingtalkDept.setName(intermediary.getIntermediaryName());
        dingtalkDept.setParentid(0);
        dingtalkDept.setOrder(0);
        dingtalkDept.setIntermediaryId(intermediary.getIntermediaryId());
        dingtalkDept.setPath(",0,");
         dingtalkDeptMapper.insert(dingtalkDept);
        //添加人
        DingtalkUser user = new DingtalkUser();
        user.setIntermediaryId(intermediary.getIntermediaryId());
        user.setName(intermediary.getIntermediaryContact());
        String tel = intermediary.getIntermediaryContactTel();
        user.setMobile(tel);
        String password =tel.substring(tel.length() - 6, tel.length());
                String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        dingtalkUserMapper.insert(user);
        //将人加到部门
        DingtalkUserDept dingtalkUserDept = new DingtalkUserDept();
        dingtalkUserDept.setDeptId(dingtalkDept.getId());
        dingtalkUserDept.setUserId(user.getUserid());
        dingtalkUserDeptMapper.insert(dingtalkUserDept);
        //设置人为管理员
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(user.getUserid());
        sysUserRole.setRoleId(1);
        sysUserRoleMapper.insert(sysUserRole);
    }
}