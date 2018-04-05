package com.we.fc.menu.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.menu.dao.MenuDao;
import com.we.fc.menu.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zdc
 * @since 2018-04-05 17:32
 */

@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired private MenuDao menuDao;

    @Override
    public BaseDao<Menu> getDao() {
        return menuDao;
    }
}
