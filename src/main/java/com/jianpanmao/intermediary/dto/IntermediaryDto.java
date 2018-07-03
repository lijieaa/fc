package com.jianpanmao.intermediary.dto;

import com.jianpanmao.area.entity.Area;
import com.jianpanmao.sys.entity.DingtalkUser;

import java.util.Date;

public class IntermediaryDto {


    private String intermediaryName;

    public String getIntermediaryName() {
        return intermediaryName;
    }

    public void setIntermediaryName(String intermediaryName) {
        this.intermediaryName = intermediaryName;
    }

    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    private Date intermediaryCreateTime;

    public Date getIntermediaryCreateTime() {
        return intermediaryCreateTime;
    }

    public void setIntermediaryCreateTime(Date intermediaryCreateTime) {
        this.intermediaryCreateTime = intermediaryCreateTime;
    }

    private String od;

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    private String intermediaryContact;

    public String getIntermediaryContact() {
        return intermediaryContact;
    }

    public void setIntermediaryContact(String intermediaryContact) {
        this.intermediaryContact = intermediaryContact;
    }

    private String intermediaryLogoUrl;

    public String getIntermediaryLogoUrl() {
        return intermediaryLogoUrl;
    }

    public void setIntermediaryLogoUrl(String intermediaryLogoUrl) {
        this.intermediaryLogoUrl = intermediaryLogoUrl;
    }

    private Date intermediaryUpdateTime;

    public Date getIntermediaryUpdateTime() {
        return intermediaryUpdateTime;
    }

    public void setIntermediaryUpdateTime(Date intermediaryUpdateTime) {
        this.intermediaryUpdateTime = intermediaryUpdateTime;
    }

    private String intermediaryIntroduction;

    public String getIntermediaryIntroduction() {
        return intermediaryIntroduction;
    }

    public void setIntermediaryIntroduction(String intermediaryIntroduction) {
        this.intermediaryIntroduction = intermediaryIntroduction;
    }

    private String intermediaryContactTel;

    public String getIntermediaryContactTel() {
        return intermediaryContactTel;
    }

    public void setIntermediaryContactTel(String intermediaryContactTel) {
        this.intermediaryContactTel = intermediaryContactTel;
    }

    private DingtalkUser user;

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    private Integer intermediaryId;

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    private Integer isPlat;

    public Integer getIsPlat() {
        return isPlat;
    }

    public void setIsPlat(Integer isPlat) {
        this.isPlat = isPlat;
    }

    private String eCode;//企业代码

    private String businessLicense;//营业执照

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }
}