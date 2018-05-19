package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysMenuDto;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysMenuExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuMapper extends BaseDao<SysMenu, SysMenuExample, SysMenuDto, Integer> {
}