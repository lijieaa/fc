package com.jianpanmao.common.config;

import com.jianpanmao.common.resolver.OrderParserResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

//@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
   /* @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new OrderParserResolver());
        super.addArgumentResolvers(argumentResolvers);
    }*/
}
