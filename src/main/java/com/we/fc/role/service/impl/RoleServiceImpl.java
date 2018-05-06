package com.we.fc.role.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.menu.dao.MenuDao;
import com.we.fc.menu.entity.Menu;
import com.we.fc.role.dao.RoleDao;
import com.we.fc.role.entity.Role;
import com.we.fc.role.service.RoleService;
import com.we.fc.user.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    RoleDao dao;



    @Override
    public BaseDao<Role> getDao() {
        return this.dao;
    }

    @Override
    public int insert(Role role) throws Exception {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        role.setIntermediaryId(intermediaryId);
        int insert = super.insert(role);
        List<Menu> menus = role.getMenus();
        for (Menu menu : menus) {
            dao.insertRM(role.getId(),menu.getId());
        }
        return insert;
    }

    @Override
    public void updateByPrimaryKey(Role role) throws Exception {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        role.setIntermediaryId(intermediaryId);

        dao.deleteRM(role.getId());


        if (null!=role.getMenus()&&role.getMenus().size()>0){
            List<Menu> menus = role.getMenus();
            for (Menu menu : menus) {
                dao.insertRM(role.getId(),menu.getId());
            }
        }




        super.updateByPrimaryKey(role);
    }
}
