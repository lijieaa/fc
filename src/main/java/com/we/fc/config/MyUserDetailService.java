package com.we.fc.config;


import com.we.fc.user.entity.DingtalkUser;
import com.we.fc.user.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

  /*  @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
*/


    @Autowired
    DingtalkUserService dingtalkUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        DingtalkUser user = dingtalkUserService.findByTel(s);

        //User user = userDao.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }/*else{
            // 查询角色
            List<Role> roles = roleDao.findByUserId(user.getId());
            user.setRoles(roles);
        }*/
        return user;
    }
}
