package com.we.fc.menu.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.menu.entity.DingtalkMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DingtalkMenuMapper extends BaseDao<DingtalkMenu>{

    /*public List<DingtalkMenu> selectChildrenById(int pid);*/

}