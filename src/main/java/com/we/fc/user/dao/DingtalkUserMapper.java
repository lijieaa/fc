package com.we.fc.user.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.user.entity.DingtalkUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DingtalkUserMapper extends BaseDao<DingtalkUser>{
    /**
     * 通过手机号查询用户
     * @param tel
     * @return
     */
    DingtalkUser findByTel(String tel);
}