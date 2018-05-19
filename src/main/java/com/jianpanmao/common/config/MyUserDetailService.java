package com.jianpanmao.common.config;


import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class MyUserDetailService implements UserDetailsService {




    @Autowired
    DingtalkUserService dingtalkUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        DingtalkUser user = dingtalkUserService.findByMobile(s);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        return user;
    }
}
