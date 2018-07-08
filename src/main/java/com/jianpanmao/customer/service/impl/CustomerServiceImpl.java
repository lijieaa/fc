package com.jianpanmao.customer.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.customer.entity.*;
import com.jianpanmao.customer.dto.*;
import com.jianpanmao.customer.service.CustomerService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer,CustomerExample,CustomerDto,Integer> implements CustomerService {

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