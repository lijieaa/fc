package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;

import java.util.List;


public interface DingtalkDeptService extends BaseService<DingtalkDept, DingtalkDeptExample,DingtalkDeptDto,Integer>{
    List<DingtalkDept> selectByPath(String path);
}