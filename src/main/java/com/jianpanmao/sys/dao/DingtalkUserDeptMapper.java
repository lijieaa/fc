package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.DingtalkUserDeptDto;
import com.jianpanmao.sys.entity.DingtalkUserDept;
import com.jianpanmao.sys.entity.DingtalkUserDeptExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DingtalkUserDeptMapper extends BaseDao<DingtalkUserDept, DingtalkUserDeptExample, DingtalkUserDeptDto, Integer> {
}