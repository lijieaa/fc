package com.we.fc.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;

//@Component("filterInvocationServiceSecurityMetadataSource")
public class FilterInvocationServiceSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
    private FilterInvocationSecurityMetadataSource delegate;
    private SecurityExpressionHandler<FilterInvocation> expressionHandler;

    @Autowired
    public FilterInvocationServiceSecurityMetadataSource(SecurityExpressionHandler<FilterInvocation> expressionHandler) {
        this.expressionHandler = expressionHandler;
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
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap=new LinkedHashMap<>();
        this.delegate = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);
    }
}
