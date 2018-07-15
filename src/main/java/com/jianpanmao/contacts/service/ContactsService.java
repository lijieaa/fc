package com.jianpanmao.contacts.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.contacts.entity.*;
import com.jianpanmao.contacts.dto.*;




public interface ContactsService extends BaseService<Contacts, ContactsExample,ContactsDto,Integer>{
    public Contacts findeByTel(String tel);
}