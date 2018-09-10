package com.jianpanmao.common.config;

import com.jianpanmao.common.filter.AdminUsernamePasswordAuthenticationFilter;
import com.jianpanmao.common.filter.WxUsernamePasswordAuthenticationFilter;
import com.jianpanmao.common.handler.LoginSuccessHandler;
import com.jianpanmao.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MultiHttpSecurityConfig {

    @Bean
    public SpringUtils springUtils() {
        return new SpringUtils();
    }


    @Bean
    public  PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        return firewall;
    }


    @Autowired
    @Qualifier("wxUserDetailService")
    private   WxUserDetailService wxUserDetailService;


    @Bean
    public  AuthenticationManager wxAuthenticationManager(){

        DaoAuthenticationProvider wxAuthenticationProvider=new DaoAuthenticationProvider();
        wxAuthenticationProvider.setUserDetailsService(wxUserDetailService);
        wxAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        List<AuthenticationProvider> providers=new ArrayList<>();
        providers.add(wxAuthenticationProvider);
        ProviderManager providerManager=new ProviderManager(providers);

        return providerManager;

    }


    @Autowired
    @Qualifier("myUserDetailService")
    private  MyUserDetailService myUserDetailService;

    @Bean
    public  AuthenticationManager adminAuthenticationManager(){

        DaoAuthenticationProvider adminAuthenticationProvider=new DaoAuthenticationProvider();
        adminAuthenticationProvider.setUserDetailsService(myUserDetailService);
        adminAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        List<AuthenticationProvider> providers=new ArrayList<>();
        providers.add(adminAuthenticationProvider);
        ProviderManager providerManager=new ProviderManager(providers);

        return providerManager;

    }



    @Configuration
    @Order(1)
    public static class WxWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("wxAuthenticationManager")
        private AuthenticationManager wxAuthenticationManager;

        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
            return wxAuthenticationManager;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf()
                    .disable()
                    .antMatcher("/wd/**")
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/wx/common/loginwx")
                    .failureUrl("/wx/common/loginwx?error=true")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }
    }


    @Configuration
    public static class WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {


        @Autowired
        @Qualifier("adminAuthenticationManager")
        private AuthenticationManager adminAuthenticationManager;


        @Autowired
        LoginSuccessHandler loginSuccessHandler;


        @Autowired
        HttpFirewall httpFirewall;


        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
            return adminAuthenticationManager;
        }


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

            http.headers().frameOptions().sameOrigin();

            http
                    .sessionManagement()
                    .invalidSessionUrl("/session_timeout")
                    .maximumSessions(1).expiredUrl("/session_timeout");


            http.formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .successHandler(loginSuccessHandler)
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }


        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .httpFirewall(httpFirewall)
                    .ignoring()
                    .antMatchers("/ace/**")
                    .antMatchers("/js/**")
                    .antMatchers("/wx/**")
                    // .antMatchers("/wd/**")
                    .antMatchers("/plugins/**")
                    .antMatchers("/css/**")
                    .antMatchers("/images/**")
                    .antMatchers("/img/**")
                    .antMatchers("/material/**")
                    .antMatchers("/*.txt");
            super.configure(web);

        }
    }


}
