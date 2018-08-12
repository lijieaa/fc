package com.jianpanmao.contacts.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.contacts.dto.ContactsDto;
import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.entity.ContactsExample;
import com.jianpanmao.customer.dto.CustomerContactDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactsMapper extends BaseDao<Contacts, ContactsExample, ContactsDto, Integer> {

    public int deleteContact2SysRole(Integer conId);

    public Contacts selectByTel(String tel);

    public List<Contacts> selectByCusId(Integer cusId);

    List<CustomerContactDto> byiId(Integer cusId);


    public int updatePwd(Integer id,String pwd);

}