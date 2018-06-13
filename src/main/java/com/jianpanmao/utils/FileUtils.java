package com.jianpanmao.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zdc
 * @since 2018-06-12 22:39
 */

public class FileUtils {


    /**
     * 获取主文件名
     * @param filename
     * @return
     */
    public static String getFileMainname(String filename) {
        int idx = filename.lastIndexOf(".");
        return filename.substring(0, idx);
    }

    /**
     * 获取文件扩展名
     * @param filename
     * @return
     */
    public static String getFileExtname(String filename){
        int idx = filename.lastIndexOf(".");
        return filename.substring(idx);
    }

    public static void download(File file, HttpServletResponse response) throws Exception {

        ServletOutputStream sos = response.getOutputStream();
        InputStream is = new FileInputStream(file);
        int len = 0;
        byte [] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1){
            sos.write(buffer, 0, len);
        }
        sos.flush();
        is.close();
        sos.close();
    }

}
