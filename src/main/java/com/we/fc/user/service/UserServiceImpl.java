package com.we.fc.user.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.user.dao.UserDao;
import com.we.fc.user.entity.User;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired private UserDao userDao;

    @Override
    public BaseDao<User> getDao() {
        return userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findCountByCompanyId(Integer companyId) {
        return userDao.findCountByCompanyId(companyId);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findCountByDeptId(Integer deptId) {
        return userDao.findCountByDeptId(deptId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByDeptId(Integer deptId) {
        return userDao.findByDeptId(deptId);
    }

    @Override
    public List<User> findByCompanyId(Integer companyId) {
        return userDao.findByCompanyId(companyId);
    }
}
