package com.we.fc.config;

import org.springframework.security.access.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

/**
 * Created by Administrator on 2018/4/28.
 */
public class MyAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        //return attribute instanceof org.springframework.security.access.SecurityConfig;
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {

        return ACCESS_DENIED;
    }
}
