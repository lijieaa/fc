package com.jianpanmao.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by mayn on 2018/4/26.
 */
public class FileUpload {

    public static String fileUpload(MultipartFile file){
        //List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        String name = null;
        if (file.isEmpty()) {
            return name;
        }
        String fileCompleteName = file.getOriginalFilename();
        String fileType = fileCompleteName.substring(fileCompleteName.lastIndexOf(".",fileCompleteName.length()));
        UUID uuid = UUID.randomUUID();
        String fileName = uuid+fileType;

        int size = (int) file.getSize();

        String path = "c:\\images";
        File dest = new File(path+File.separator+fileName);
        if (!dest.getParentFile().exists()) { //判断文件目录是否存在
            dest.getParentFile().mkdirs();
            System.out.println("创建文件成功！："+dest.getAbsolutePath());
        }
        try {
            file.transferTo(dest); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }
}
