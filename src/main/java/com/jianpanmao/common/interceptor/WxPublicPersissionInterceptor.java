package com.jianpanmao.common.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-07-18 22:10
 */
@Component
public class WxPublicPersissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("wxuser") == null) {
            response.sendRedirect("/wx/common/loginwx");
        }
    }
}
