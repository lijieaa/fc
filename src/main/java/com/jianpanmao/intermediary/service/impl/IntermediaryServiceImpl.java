package com.jianpanmao.intermediary.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.exception.CustomException;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IntermediaryServiceImpl extends BaseServiceImpl<Intermediary, IntermediaryExample, IntermediaryDto, Integer> implements IntermediaryService {

    @Autowired
    DingtalkDeptMapper dingtalkDeptMapper;

    @Autowired
    DingtalkUserMapper dingtalkUserMapper;

    @Autowired
    DingtalkUserDeptMapper dingtalkUserDeptMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

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
    public int add(Intermediary record) {
        Integer iId = super.add(record);
             /*   Intermediary intermediary = super.get(iId);
        //添加部门
        DingtalkDept dingtalkDept = new DingtalkDept();
        dingtalkDept.setName(intermediary.getIntermediaryName());
        dingtalkDept.setParentid(1);
        dingtalkDept.setOrder(0);
        dingtalkDept.setIntermediaryId(intermediary.getIntermediaryId());
        dingtalkDept.setPath("0");
        int deptId = dingtalkDeptMapper.insert(dingtalkDept);
        //添加人
        DingtalkUser user = new DingtalkUser();
        user.setIntermediaryId(iId);
        user.setName(intermediary.getIntermediaryContact());
        String tel = intermediary.getIntermediaryContactTel();
        user.setMobile(tel);
        user.setPassword(tel.substring(tel.length()-6,tel.length()));
        int userId = dingtalkUserMapper.insert(user);
        //将人加到部门
        DingtalkUserDept dingtalkUserDept = new DingtalkUserDept();
        dingtalkUserDept.setDeptId(deptId);
        dingtalkUserDept.setUserId(userId);
        dingtalkUserDeptMapper.insert(dingtalkUserDept);
        //设置人为管理员
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userId);
        sysUserRole.setRoleId(1);
        sysUserRoleMapper.insert(sysUserRole);*/
        return iId;
    }
}