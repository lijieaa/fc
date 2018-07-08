package com.jianpanmao.customer.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.customer.dto.CustomerDto;
import com.jianpanmao.customer.entity.Customer;
import com.jianpanmao.customer.entity.CustomerExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseDao<Customer, CustomerExample, CustomerDto, Integer> {
}