package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.DingtalkUserDto;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.DingtalkUserExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DingtalkUserMapper extends BaseDao<DingtalkUser, DingtalkUserExample, DingtalkUserDto, Integer> {

    DingtalkUser findByMobile(String mobile);
}