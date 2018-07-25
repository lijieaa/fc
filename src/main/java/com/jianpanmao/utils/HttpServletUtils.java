package com.jianpanmao.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zdc
 * @since 2018-06-13 23:24
 */

public class HttpServletUtils {

    public static void responseWriter(HttpServletResponse response, String str) throws Exception {


        ServletOutputStream os = response.getOutputStream();

        os.write(str.getBytes("utf-8"));

        os.flush();

        os.close();
    }
}
