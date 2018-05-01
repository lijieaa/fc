package com.we.fc.user.service;

import com.we.fc.base.BaseService;
import com.we.fc.user.entity.DingtalkUser;

import java.util.List;

/**
 * Created by visizen on 2018/4/15 0015.
 */
public interface DingtalkUserService extends BaseService<DingtalkUser>{

    /**
     * 通过手机号查询用户
     * @param tel
     * @return
     */
    DingtalkUser findByTel(String tel);


    List<DingtalkUser> findByDeptId(Integer deptId);


}
