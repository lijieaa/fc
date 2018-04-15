package com.we.fc.user.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.user.dao.DingtalkUserMapper;
import com.we.fc.user.entity.DingtalkUser;
import com.we.fc.user.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DingtalkServiceImpl extends BaseServiceImpl<DingtalkUser> implements DingtalkUserService {

    private DingtalkUserMapper dingtalkUserMapper;

    @Autowired
    public DingtalkServiceImpl(DingtalkUserMapper dingtalkUserMapper) {
        this.dingtalkUserMapper=dingtalkUserMapper;
    }

    @Override
    public BaseDao<DingtalkUser> getDao() {
        return dingtalkUserMapper;
    }
}
