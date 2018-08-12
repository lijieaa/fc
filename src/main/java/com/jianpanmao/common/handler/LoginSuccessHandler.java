package com.jianpanmao.common.handler;

import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysRole;
import com.jianpanmao.sys.service.SysMenuService;
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

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    SysMenuService menuService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        DingtalkUser user = (DingtalkUser)authentication.getPrincipal();


        List<SysMenu> menusArr=new ArrayList<>();


        List<SysRole> roles = user.getRoles();

        for (SysRole role : roles) {
            List<SysMenu> menus = role.getMenus();
            menusArr.addAll(menus);
        }

        //List<SysMenu> menus = menuService.getAll(null);

        request.getSession().setAttribute("menus",menusArr);

        request.getSession().setAttribute("user", user);

        request.getSession().setAttribute("intermediary", user.getIntermediary());


        super.getRedirectStrategy().sendRedirect(request, response, "/index");


    }
}
