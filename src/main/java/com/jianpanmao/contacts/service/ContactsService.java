package com.jianpanmao.contacts.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.contacts.entity.*;
import com.jianpanmao.contacts.dto.*;

import java.util.List;


public interface ContactsService extends BaseService<Contacts, ContactsExample,ContactsDto,Integer>{
    public Contacts findeByTel(String tel);

    public List<Contacts> findByCusId(Integer cusId);


    public int updatePwd(Integer id,String pwd);
}