package com.jianpanmao.customer.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.customer.dto.CustomerContactDto;
import com.jianpanmao.customer.dto.CustomerDto;
import com.jianpanmao.customer.entity.Customer;
import com.jianpanmao.customer.entity.CustomerExample;
import com.jianpanmao.customer.service.impl.CustomerServiceImpl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseDao<Customer, CustomerExample, CustomerDto, Integer> {
    List<CustomerContactDto> byIntermediary(Integer iId);
}