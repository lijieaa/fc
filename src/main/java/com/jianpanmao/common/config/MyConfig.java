package com.jianpanmao.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "fc")
public class MyConfig {


    private String imgContext;


    private String uploadPath;

    public String getImgContext() {
        return imgContext;
    }

    @Value("${imgContext}")
    public void setImgContext(String imgContext) {
        this.imgContext = imgContext;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    @Value("${uploadPath}")
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
