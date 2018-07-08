package com.jianpanmao.contacts.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.contacts.entity.*;
import com.jianpanmao.contacts.dto.*;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl extends BaseServiceImpl<Contacts,ContactsExample,ContactsDto,Integer> implements ContactsService {

    @Override
    public int add(Contacts record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.add(record);
    }

    @Override
    public int update(Contacts record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.update(record);
    }
}