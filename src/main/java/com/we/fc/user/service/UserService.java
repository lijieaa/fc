package com.we.fc.user.service;

import com.we.fc.base.BaseService;
import com.we.fc.user.entity.DingtalkUser;

import java.util.List;


/**
 * @author zdc
 * @since 2018-04-03 22:00
 */
public interface UserService extends BaseService<DingtalkUser> {

    List<DingtalkUser> findByCompanyId(Integer companyId);
}
