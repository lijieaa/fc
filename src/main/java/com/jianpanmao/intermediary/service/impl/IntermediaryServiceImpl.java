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
import com.jianpanmao.sys.dto.ContactsDto;
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
    public Intermediary get(Integer TId) {
        Intermediary intermediary = super.get(TId);
        List<ContactsDto> contactsDtoList = dingtalkUserMapper.intermediaryContactUser(TId);
        intermediary.setContacts(contactsDtoList);
        return intermediary;
    }

    @Override
    @Transactional
    public int update(Intermediary record) {
        intermediaryMapper.deleteContacts(record.getIntermediaryId());
        String fcUser = record.getFcUser();
        String myUser = record.getMyUser();
        if (null != fcUser && fcUser.length() > 0) {
            addContacts(fcUser, record.getIntermediaryId(), 0);
        }
        if (null != myUser && myUser.length() > 0) {
            addContacts(myUser, record.getIntermediaryId(), 1);
        }
        return super.update(record);
    }

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
            addContacts(fcUser, record.getIntermediaryId(), 0);
        }
        return record.getIntermediaryId();
    }

    //添加联系人(status 0:平台；1：中间商)
    private void addContacts(String str, Integer iId, Integer status) {
        List<IntermediaryUser> intermediaryUsers = new ArrayList<>();
        String[] fcUsers = str.split(",");
        for (String u : fcUsers) {
            IntermediaryUser intermediaryUser = new IntermediaryUser();
            intermediaryUser.setIntermediaryUserIid(iId);
            intermediaryUser.setIntermediaryUserUid(Integer.valueOf(u));
            intermediaryUser.setIntermediaryUserStatus(status);
            intermediaryUsers.add(intermediaryUser);
        }
        intermediaryMapper.addFcUser(intermediaryUsers);
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
        String password = tel.substring(tel.length() - 6, tel.length());
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
        addContacts(user.getUserid().toString(), intermediary.getIntermediaryId(), 1);
    }
}