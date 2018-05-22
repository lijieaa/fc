package com.jianpanmao.wxpublic.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WxPublicDto {


    private String sourceId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    private Date wxPublicCreateTime;

    public Date getWxPublicCreateTime() {
        return wxPublicCreateTime;
    }

    public void setWxPublicCreateTime(Date wxPublicCreateTime) {
        this.wxPublicCreateTime = wxPublicCreateTime;
    }

    private String publicName;

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    private String od;

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    private Date wxPublicUpdateTime;

    public Date getWxPublicUpdateTime() {
        return wxPublicUpdateTime;
    }

    public void setWxPublicUpdateTime(Date wxPublicUpdateTime) {
        this.wxPublicUpdateTime = wxPublicUpdateTime;
    }

    private String appSecret;

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    private Integer publicId;

    public Integer getPublicId() {
        return publicId;
    }

    public void setPublicId(Integer publicId) {
        this.publicId = publicId;
    }

    private String publicEmail;

    public String getPublicEmail() {
        return publicEmail;
    }

    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail;
    }

    private Integer intermediaryId;

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }
}