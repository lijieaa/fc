package com.we.fc.base;


import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.MenuService;
import com.we.fc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-03-31 23:52
 */

public abstract class BaseController<T> {

    public abstract BaseService<T> getService();

    @Autowired
    private MenuService menuService;

    protected User getSelf(HttpSession session){
        return (User)session.getAttribute("user");
    }

    protected Menu getMenuById(Integer menuId){
        return menuService.findById(menuId);
    }

}
