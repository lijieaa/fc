package com.we.fc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zdc
 * @since 2018-03-26 21:50
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private MyUserDetailService myUserDetailService;

    //@Resource
   // private MySecurityMetadataSource mySecurityMetadataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/bower_components/**")
                .antMatchers("/plugins/**")
                .antMatchers("/dist/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/css/**")
                .antMatchers("/druid2/**")
                .antMatchers("/wx/**")
                .antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/test").hasAuthority("view:admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(loginSuccessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }



   /*@Bean
    public FilterSecurityInterceptor filterSecurityInterceptor() {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(mySecurityMetadataSource());
        filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
        return filterSecurityInterceptor;
    }


   @Bean
    public FilterInvocationSecurityMetadataSource mySecurityMetadataSource() {
        return new MySecurityMetadataSource();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters=new ArrayList<>();
        //decisionVoters.add(new AuthenticatedVoter());
        //decisionVoters.add(new MyAccessDecisionVoter());
        decisionVoters.add(new WebExpressionVoter());
        //decisionVoters.add(new RoleVoter());
        return new AffirmativeBased(decisionVoters);
    }*/
}
