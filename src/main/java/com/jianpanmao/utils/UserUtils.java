package com.jianpanmao.utils;

import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by mayn on 2018/5/26.
 */
public class UserUtils {
    public static DingtalkUser getUser(){
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
