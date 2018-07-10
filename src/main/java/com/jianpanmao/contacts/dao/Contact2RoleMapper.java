package com.jianpanmao.contacts.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.contacts.dto.Contact2RoleDto;
import com.jianpanmao.contacts.entity.Contact2Role;
import com.jianpanmao.contacts.entity.Contact2RoleExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Contact2RoleMapper extends BaseDao<Contact2Role, Contact2RoleExample, Contact2RoleDto, Integer> {


}