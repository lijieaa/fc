package com.we.fc.user;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.menu.service.MenuService;
import com.we.fc.user.entity.User;
import com.we.fc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-05 17:57
 */

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired private UserService userService;

    @Autowired private MenuService menuService;

    @Override
    public BaseService<User> getService() {
        return userService;
    }

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", menuService.findById(menuId));
        return "sys/user/index";
    }
}
