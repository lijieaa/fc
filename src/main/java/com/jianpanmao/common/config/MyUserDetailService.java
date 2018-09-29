package com.jianpanmao.common.config;


import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private final Log logger = LogFactory.getLog(MyUserDetailService.class);


    @Autowired
    DingtalkUserService dingtalkUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        DingtalkUser user = dingtalkUserService.findByMobile(s,null);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }


        logger.error(user.getAuthorities());
        return user;
    }
}
