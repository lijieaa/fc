package com.we.fc.menu.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.menu.dao.DingtalkMenuMapper;
import com.we.fc.menu.entity.DingtalkMenu;
import com.we.fc.menu.service.DingtalkMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DingtalkMenuServiceImpl extends BaseServiceImpl<DingtalkMenu> implements DingtalkMenuService {

    @Autowired
    DingtalkMenuMapper dingtalkMenuMapper;

    @Override
    public BaseDao<DingtalkMenu> getDao() {
        return dingtalkMenuMapper;
    }
}
