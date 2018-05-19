package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysRoleDto;
import com.jianpanmao.sys.entity.SysRole;
import com.jianpanmao.sys.entity.SysRoleExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper extends BaseDao<SysRole, SysRoleExample, SysRoleDto, Integer> {

    int insertRM(Integer roleId,Integer menuId);
}