package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.DingtalkUserDto;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.DingtalkUserExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DingtalkUserMapper extends BaseDao<DingtalkUser, DingtalkUserExample, DingtalkUserDto, Integer> {

    DingtalkUser findByMobile(String mobile);
    List<DingtalkUser> idNameList(Integer intermediaryId);
}