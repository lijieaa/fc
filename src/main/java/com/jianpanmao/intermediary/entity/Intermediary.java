package com.jianpanmao.intermediary.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Intermediary implements Serializable {
    //
    private Integer intermediaryId;

    //中间商名称
    @NotNull(message = "intermediaryName不能为空！")
    private String intermediaryName;

    //中间商联系人
    @NotNull(message = "intermediaryContact不能为空！")
    private String intermediaryContact;

    //中间商联系方式
    @NotNull(message = "intermediaryContactTel不能为空！")
    private String intermediaryContactTel;

    //所属地区
    @NotNull(message = "areaId不能为空！")
    private Integer areaId;

    //平台对接人
    @NotNull(message = "userId不能为空！")
    private Integer userId;

    //平台LOGO
    @NotNull(message = "intermediaryLogoUrl不能为空！")
    private String intermediaryLogoUrl;

    //创建时间
    private Date intermediaryCreateTime;

    //更新时间
    private Date intermediaryUpdateTime;

    //
    private Integer isPlat;

    //图文简介
    @NotNull(message = "intermediaryIntroduction不能为空！")
    private String intermediaryIntroduction;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public String getIntermediaryName() {
        return intermediaryName;
    }

    public void setIntermediaryName(String intermediaryName) {
        this.intermediaryName = intermediaryName == null ? null : intermediaryName.trim();
    }

    public String getIntermediaryContact() {
        return intermediaryContact;
    }

    public void setIntermediaryContact(String intermediaryContact) {
        this.intermediaryContact = intermediaryContact == null ? null : intermediaryContact.trim();
    }

    public String getIntermediaryContactTel() {
        return intermediaryContactTel;
    }

    public void setIntermediaryContactTel(String intermediaryContactTel) {
        this.intermediaryContactTel = intermediaryContactTel == null ? null : intermediaryContactTel.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIntermediaryLogoUrl() {
        return intermediaryLogoUrl;
    }

    public void setIntermediaryLogoUrl(String intermediaryLogoUrl) {
        this.intermediaryLogoUrl = intermediaryLogoUrl == null ? null : intermediaryLogoUrl.trim();
    }

    public Date getIntermediaryCreateTime() {
        return intermediaryCreateTime;
    }

    public void setIntermediaryCreateTime(Date intermediaryCreateTime) {
        this.intermediaryCreateTime = intermediaryCreateTime;
    }

    public Date getIntermediaryUpdateTime() {
        return intermediaryUpdateTime;
    }

    public void setIntermediaryUpdateTime(Date intermediaryUpdateTime) {
        this.intermediaryUpdateTime = intermediaryUpdateTime;
    }

    public Integer getIsPlat() {
        return isPlat;
    }

    public void setIsPlat(Integer isPlat) {
        this.isPlat = isPlat;
    }

    public String getIntermediaryIntroduction() {
        return intermediaryIntroduction;
    }

    public void setIntermediaryIntroduction(String intermediaryIntroduction) {
        this.intermediaryIntroduction = intermediaryIntroduction == null ? null : intermediaryIntroduction.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", intermediaryName=").append(intermediaryName);
        sb.append(", intermediaryContact=").append(intermediaryContact);
        sb.append(", intermediaryContactTel=").append(intermediaryContactTel);
        sb.append(", areaId=").append(areaId);
        sb.append(", userId=").append(userId);
        sb.append(", intermediaryLogoUrl=").append(intermediaryLogoUrl);
        sb.append(", intermediaryCreateTime=").append(intermediaryCreateTime);
        sb.append(", intermediaryUpdateTime=").append(intermediaryUpdateTime);
        sb.append(", isPlat=").append(isPlat);
        sb.append(", intermediaryIntroduction=").append(intermediaryIntroduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}