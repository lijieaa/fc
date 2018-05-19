package com.jianpanmao.common.filter;


import com.jianpanmao.common.utils.StringUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

public class ModifyParametersFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ModifyParametersWrapper mParametersWrapper = new ModifyParametersWrapper(request);
        filterChain.doFilter(mParametersWrapper, response);
    }

    private class ModifyParametersWrapper extends HttpServletRequestWrapper {
        private Map<String, String[]> parameterMap;

        public ModifyParametersWrapper(HttpServletRequest request) {
            super(request);
            parameterMap = request.getParameterMap();
        }

        @Override
        public Enumeration<String> getParameterNames() {
            Vector<String> vector = new Vector<String>(parameterMap.keySet());
            return vector.elements();
        }


        @Override
        public String getParameter(String name) {

            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                return results[0];
            }
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                int length = results.length;
                for (int i = 0; i < length; i++) {
                    if(name.equals("od")){
                        results[i] = StringUtil.orderByStringProcess(results[i]);
                    }
                }
                return results;
            }
        }
    }

}
