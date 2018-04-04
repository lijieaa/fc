package com.we.fc.role.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.role.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 14:27
 */
@Mapper
public interface RoleDao extends BaseDao<Role> {

    List<Role> findByUserId(Integer userId);
}
