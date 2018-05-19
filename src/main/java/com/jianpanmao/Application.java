package com.jianpanmao;

import com.jianpanmao.common.filter.ModifyParametersFilter;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }


    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ModifyParametersFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    if(source.equals("")){
                        return null;
                    }else{
                        date = sdf.parse((String) source);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        };
    }
}
