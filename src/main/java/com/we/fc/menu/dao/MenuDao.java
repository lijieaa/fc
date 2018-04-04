package com.we.fc.menu.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-30 23:13
 */
@Mapper
public interface MenuDao extends BaseDao<Menu> {

    List<Menu> findDisplay();

    List<Menu> findByRoleId(Integer roleId);
}
