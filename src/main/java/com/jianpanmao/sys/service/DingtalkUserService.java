package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;

import java.util.List;


public interface DingtalkUserService extends BaseService<DingtalkUser, DingtalkUserExample,DingtalkUserDto,Integer>{
    DingtalkUser findByMobile(String mobile);

    List<DingtalkUser> selectByDeptId(Integer deptId);

    List<DingtalkUser> selectByLikeName(String name);

    List<DingtalkUser> selectByRoleId(Integer roleId);

    Integer editPwd(Integer id, String pwd);

    Integer updateInfo(DingtalkUser entity);
}