package com.we.fc.menu.dao;

import com.we.fc.menu.entity.DingtalkMenu;
import java.util.List;

public interface DingtalkMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(DingtalkMenu record);

    DingtalkMenu selectByPrimaryKey(Integer menuId);

    List<DingtalkMenu> selectAll();

    int updateByPrimaryKey(DingtalkMenu record);
}