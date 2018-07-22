package com.jianpanmao.customer.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.contacts.dao.ContactsMapper;
import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.customer.entity.*;
import com.jianpanmao.customer.dto.*;
import com.jianpanmao.customer.service.CustomerService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer,CustomerExample,CustomerDto,Integer> implements CustomerService {

    @Autowired
    ContactsService contactsService;

    @Override
    public int remove(Integer id) {
        List<Contacts> contacts = contactsService.findByCusId(id);
        for (Contacts contact : contacts) {
            contactsService.remove(contact.getConId());
        }
        return super.remove(id);
    }

    @Override
    public int add(Customer record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.add(record);
    }

    @Override
    public int update(Customer record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.update(record);
    }


}