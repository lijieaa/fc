package com.jianpanmao.wxpublic.entity;

import com.jianpanmao.intermediary.entity.Intermediary;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class WxPublic implements Serializable {
    //
    private Integer publicId;

    private Intermediary intermediary;

    //公众号名称
    @NotNull(message = "publicName不能为空！")
    private String publicName;

    //原始ID
    @NotNull(message = "sourceId不能为空！")
    private String sourceId;

    //appid
    @NotNull(message = "appId不能为空！")
    private String appId;

    //app_secret
    @NotNull(message = "appSecret不能为空！")
    private String appSecret;

    //email
    @NotNull(message = "publicEmail不能为空！")
    private String publicEmail;

    private Integer intermediaryId;

    private Date wxPublicCreateTime;

    private Date wxPublicUpdateTime;

    private static final long serialVersionUID = 1L;

    String od;

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    public Integer getPublicId() {
        return publicId;
    }

    public void setPublicId(Integer publicId) {
        this.publicId = publicId;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName == null ? null : publicName.trim();
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getPublicEmail() {
        return publicEmail;
    }

    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail == null ? null : publicEmail.trim();
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getWxPublicCreateTime() {
        return wxPublicCreateTime;
    }

    public void setWxPublicCreateTime(Date wxPublicCreateTime) {
        this.wxPublicCreateTime = wxPublicCreateTime;
    }

    public Date getWxPublicUpdateTime() {
        return wxPublicUpdateTime;
    }

    public void setWxPublicUpdateTime(Date wxPublicUpdateTime) {
        this.wxPublicUpdateTime = wxPublicUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", publicId=").append(publicId);
        sb.append(", publicName=").append(publicName);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", appId=").append(appId);
        sb.append(", appSecret=").append(appSecret);
        sb.append(", publicEmail=").append(publicEmail);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", wxPublicCreateTime=").append(wxPublicCreateTime);
        sb.append(", wxPublicUpdateTime=").append(wxPublicUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}