package com.we.fc.user.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.user.dao.DingtalkUserMapper;
import com.we.fc.user.entity.DingtalkUser;
import com.we.fc.user.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingtalkServiceImpl extends BaseServiceImpl<DingtalkUser> implements DingtalkUserService {

    @Autowired
    PasswordEncoder encoder;

    private DingtalkUserMapper dingtalkUserMapper;

    @Autowired
    public DingtalkServiceImpl(DingtalkUserMapper dingtalkUserMapper) {
        this.dingtalkUserMapper=dingtalkUserMapper;
    }

    @Override
    public BaseDao<DingtalkUser> getDao() {
        return dingtalkUserMapper;
    }

    @Override
    public void insert(DingtalkUser dingtalkUser) throws Exception {
        //dingtalkUser.get
        dingtalkUser.setPwd(encoder.encode(dingtalkUser.getPwd()));
        super.insert(dingtalkUser);
    }

    @Override
    public void updateByPrimaryKey(DingtalkUser dingtalkUser) throws Exception {
        dingtalkUser.setPwd(encoder.encode(dingtalkUser.getPwd()));
        super.updateByPrimaryKey(dingtalkUser);
    }

    @Override
    public DingtalkUser findByTel(String tel) {
        return dingtalkUserMapper.findByTel(tel);
    }

    @Override
    public List<DingtalkUser> findByDeptId(Integer deptId) {
        return dingtalkUserMapper.findByDeptId(deptId);
    }
}
