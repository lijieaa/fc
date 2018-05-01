package com.we.fc.role.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.role.entity.Role;
import com.we.fc.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    RoleService service;

    @Override
    public BaseService<Role> getService() {
        return service;
    }

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "sys/role/index";
    }
}
