package com.we.fc.config;

import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.MenuService;
import com.we.fc.menu.service.MenuServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.*;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.*;

public class MySecurityMetadataSource  implements FilterInvocationSecurityMetadataSource,InitializingBean {




    protected final Log logger = LogFactory.getLog(getClass());

    FilterInvocationSecurityMetadataSource delegate;


    public MySecurityMetadataSource() {


    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {

        return this.delegate.getAllConfigAttributes();
    }

    public Collection<ConfigAttribute> getAttributes(Object object) {
        return this.delegate.getAttributes(object);
    }

    public boolean supports(Class<?> clazz) {
        return this.delegate.supports(clazz);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        RequestMatcher requestMatcher = new AntPathRequestMatcher("/admin/create");
        Collection<ConfigAttribute> configAttributes = new LinkedHashSet<>();
        configAttributes.add(new SecurityConfig("hasAuthority('create:admin')"));
        requestMap.put(requestMatcher,configAttributes);
       // RequestMatcher matcher = requestConfigMapping.getMatcher();
        //requestMap.put(matcher,requestConfigMapping.getAttributes());
        FilterInvocationSecurityMetadataSource metadataSource =
                new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, new DefaultWebSecurityExpressionHandler());
        this.delegate = metadataSource;
    }
}
