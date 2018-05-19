package com.jianpanmao.common.resolver;

import com.jianpanmao.common.annotation.OrderParser;
import com.jianpanmao.common.utils.StringUtil;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

public class OrderParserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
       /* Annotation[]  methodAnnotations= parameter.getParameterAnnotations();
        for(Annotation  annotation:methodAnnotations){
            if(annotation instanceof OrderParser){
                HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
                System.out.println(request.getParameter("order"));
                System.out.println(request.getParameterValues("order"));
                StringUtil.orderByStringProcess(request.getParameter("order"));
                return  "t_id desc";
            }
        }*/
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String order = request.getParameter("order");
        if(order!=null){
            request.setAttribute("order",StringUtil.orderByStringProcess(order));
            System.out.println("------------------:"+request.getParameter("order"));
        }



        return null;
    }
}
