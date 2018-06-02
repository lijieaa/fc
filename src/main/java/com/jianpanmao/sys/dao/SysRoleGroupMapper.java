package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysRoleGroupDto;
import com.jianpanmao.sys.entity.SysRoleGroup;
import com.jianpanmao.sys.entity.SysRoleGroupExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleGroupMapper extends BaseDao<SysRoleGroup, SysRoleGroupExample, SysRoleGroupDto, Integer> {
}