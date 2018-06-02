package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysRoleMenuDto;
import com.jianpanmao.sys.entity.SysRoleMenu;
import com.jianpanmao.sys.entity.SysRoleMenuExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMenuMapper extends BaseDao<SysRoleMenu, SysRoleMenuExample, SysRoleMenuDto, Integer> {
}