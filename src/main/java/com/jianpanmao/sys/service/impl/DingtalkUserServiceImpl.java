package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DingtalkUserServiceImpl extends BaseServiceImpl<DingtalkUser,DingtalkUserExample,DingtalkUserDto,Integer> implements DingtalkUserService {

    @Autowired
    DingtalkUserMapper dingtalkUserMapper;

    @Override
    public DingtalkUser findByMobile(String mobile) {
        return dingtalkUserMapper.findByMobile(mobile);
    }
}