package com.we.fc.user;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.common.DataTable;
import com.we.fc.user.entity.User;
import com.we.fc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-05 17:57
 */

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired private UserService userService;

    @Override
    public BaseService<User> getService() {
        return userService;
    }

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "sys/user/index";
    }

    @GetMapping("findByDeptId")
    @ResponseBody
    public DataTable findByDeptId(Integer deptId){
        return new DataTable<>(userService.findByDeptId(deptId));
    }

    @GetMapping("findByCompanyId")
    @ResponseBody
    public DataTable findByCompanyId(HttpSession session){
        return new DataTable<>(userService.findByCompanyId(getSelf(session).getCompany().getId()));
    }

}
