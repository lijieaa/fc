package com.we.fc.user.service;

import com.we.fc.base.BaseService;
import com.we.fc.user.entity.User;

/**
 * @author zdc
 * @since 2018-04-03 22:00
 */
public interface UserService extends BaseService<User> {

    Integer findCountByCompanyId(Integer companyId);

    Integer findCountByDeptId(Integer deptId);
}
