package com.jianpanmao.common.config;


import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.sys.dao.SysRoleMapper;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysRole;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class WxUserDetailService implements UserDetailsService {

    private final Log logger = LogFactory.getLog(WxUserDetailService.class);


    @Autowired
    ContactsService contactsService;


    @Autowired
   SysRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Contacts user = contactsService.findeByTel(s);






        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }


        List<SysRole> roles = roleMapper.findByConId(user.getConId());

        Collection<GrantedAuthority> authorities=new HashSet<>();

        for (SysRole role : roles) {
            List<SysMenu> menus = role.getMenus();
            for (SysMenu menu : menus)
                if (menu.getMenuPrmission() != null && menu.getMenuPrmission().length() > 0) {
                    authorities.add(new SimpleGrantedAuthority(menu.getMenuPrmission().trim()));
                }
        }

       // user.setAuthorities(authorities);
        logger.error("----------------------"+user.getAuthorities());
        return user;
    }
}
