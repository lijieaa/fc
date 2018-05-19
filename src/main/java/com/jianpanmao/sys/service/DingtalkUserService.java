package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;




public interface DingtalkUserService extends BaseService<DingtalkUser, DingtalkUserExample,DingtalkUserDto,Integer>{
    DingtalkUser findByMobile(String mobile);
}