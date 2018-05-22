package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysMenuDto;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysMenuExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseDao<SysMenu, SysMenuExample, SysMenuDto, Integer> {

    List<SysMenu> selectByPath(SysMenu sysMenu);

    void updatePath(SysMenu sysMenu);
}