package com.we.fc.user.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zdc
 * @since 2018-03-27 22:40
 */
@Mapper
public interface UserDao extends BaseDao<User> {

    User findByUsername(String username);

    /**
     * 查询该公司下的员工数
     * @param companyId
     * @return
     */
    Integer findCountByCompanyId(Integer companyId);

    /**
     * 查询该部门下的员工数
     * @param deptId
     * @return
     */
    Integer findCountByDeptId(Integer deptId);
}
