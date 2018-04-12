package com.we.fc.config;

import com.we.fc.company.dao.CompanyDao;
import com.we.fc.dept.dao.DeptDao;
import com.we.fc.menu.dao.MenuDao;
import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.utils.MenuUtils;
import com.we.fc.role.dao.RoleDao;
import com.we.fc.role.entity.Role;
import com.we.fc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Autowired private RoleDao roleDao;

    @Autowired private MenuDao menuDao;

    @Autowired private CompanyDao companyDao;

    @Autowired private DeptDao deptDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        User user = (User)authentication.getPrincipal();

        // 查询菜单
        if(user.getPlatformAdmin().equals(1)){
            List<Menu> allMenus = menuDao.findDisplay();
            Set<Menu> menuSet = MenuUtils.getLevelMenu(new TreeSet<>(allMenus));
            user.setMenus(menuSet);
        }else{
            List<Menu> menus = new ArrayList<>();
            for(Role role : user.getRoles()){
                menus.addAll(menuDao.findByRoleId(role.getId()));
            }
            user.setMenus(MenuUtils.getLevelMenu(new TreeSet<>(menus)));
        }
        // 查询公司部门
        user.setCompany(companyDao.selectByPrimaryKey(user.getCompany().getId()));
        user.setDept(deptDao.selectByPrimaryKey(user.getDept().getId()));
        request.getSession().setAttribute("user", user);
        super.getRedirectStrategy().sendRedirect(request, response, "/index");
    }
}
