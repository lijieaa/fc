package com.jianpanmao.contacts.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.contacts.dao.Contact2RoleMapper;
import com.jianpanmao.contacts.dao.ContactsMapper;
import com.jianpanmao.contacts.entity.*;
import com.jianpanmao.contacts.dto.*;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl extends BaseServiceImpl<Contacts,ContactsExample,ContactsDto,Integer> implements ContactsService {


    @Autowired
    Contact2RoleMapper contact2RoleMapper;

    @Autowired
    ContactsMapper contactsMapper;

    @Override
    public int removeBatch(Integer[] ids) {
        for (Integer id : ids) {
            contactsMapper.deleteContact2SysRole(id);
        }
        return super.removeBatch(ids);
    }

    @Override
    public int remove(Integer tId) {
        contactsMapper.deleteContact2SysRole(tId);
        return super.remove(tId);
    }

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public int add(Contacts record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        record.setPwd(passwordEncoder.encode(record.getPwd().trim()));
        int add = super.add(record);
        List<SysRole> roles = record.getRoles();
        for (SysRole role : roles) {
            Contact2Role contact2Role=new Contact2Role(record.getConId(),role.getRoleId());
            contact2RoleMapper.insert(contact2Role);
        }
        return add;
    }

    @Override
    public int update(Contacts record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());

        contactsMapper.deleteContact2SysRole(record.getConId());

        List<SysRole> newRoles = record.getRoles();
        for (SysRole role : newRoles) {
            Contact2Role contact2Role=new Contact2Role(record.getConId(),role.getRoleId());
            contact2RoleMapper.insert(contact2Role);
        }

        return super.update(record);
    }

    @Override
    public Contacts findeByTel(String tel) {
        return contactsMapper.selectByTel(tel);
    }

    @Override
    public List<Contacts> findByCusId(Integer cusId) {
        return contactsMapper.selectByCusId(cusId);
    }
}