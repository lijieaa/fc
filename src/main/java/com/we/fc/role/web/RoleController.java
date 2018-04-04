package com.we.fc.role.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.role.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-04 21:50
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController<Role> {

    @Override
    public BaseService<Role> getService() {
        return null;
    }

    @GetMapping("index")
    public String index(HttpSession session){
        return "sys/role/index";
    }
}
