package com.jianpanmao.common.config;

import com.jianpanmao.common.handler.LoginSuccessHandler;
import com.jianpanmao.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/session_timeout")
                .permitAll()
                .anyRequest().authenticated();
                //.anyRequest().permitAll()


        http
                .sessionManagement()
                .invalidSessionUrl("/session_timeout")
                .maximumSessions(1).expiredUrl("/session_timeout");


        http .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(loginSuccessHandler)
                .permitAll()
                       .and()
                .logout()
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
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder().username("admin")
                        .password("1")
                        .roles("USER")
                        .authorities("sysmenu:view","sysmenu:add","sysmenu:delete","sysmenu:edit")
                        .build();

        Collection<UserDetails> users=new ArrayList<>();
        users.add(user);
        return new InMemoryUserDetailsManager(users);
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/ace/**")
                .antMatchers("/js/**")
                .antMatchers("/wx/**")
                .antMatchers("/plugins/**")
         .antMatchers("/css/**")
                .antMatchers("/images/**");
        super.configure(web);
    }

    @Bean
    public SpringUtils springUtils(){
        return new SpringUtils();
    }
}
