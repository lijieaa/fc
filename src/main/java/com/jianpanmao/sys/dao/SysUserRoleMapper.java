package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysUserRoleDto;
import com.jianpanmao.sys.entity.SysUserRole;
import com.jianpanmao.sys.entity.SysUserRoleExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper extends BaseDao<SysUserRole, SysUserRoleExample, SysUserRoleDto, Integer> {
}