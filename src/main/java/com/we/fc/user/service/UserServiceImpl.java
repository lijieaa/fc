package com.we.fc.user.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.user.dao.DingtalkUserMapper;
import com.we.fc.user.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-03 22:00
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<DingtalkUser> implements UserService {

    @Autowired private DingtalkUserMapper userDao;

    @Override
    public BaseDao<DingtalkUser> getDao() {
        return userDao;
    }

    @Override
    public List<DingtalkUser> findByCompanyId(Integer companyId) {
        return null;
    }
}
