package com.we.fc.base;


import com.we.fc.user.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-03-31 23:52
 */

public abstract class BaseController<T> {

    public abstract BaseService<T> getService();

    protected User getSelf(HttpSession session){
        return (User)session.getAttribute("user");
    }

}
