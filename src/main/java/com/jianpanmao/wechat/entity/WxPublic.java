package com.jianpanmao.wechat.entity;


import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.wechat.base.BaseEntity;

/**
 * @author zdc
 * @since 2018-04-13 21:28
 */

public class WxPublic extends BaseEntity {

    private String publicName;

    private String sourceId;

    private String appId;

    private String appSecret;

    private String publicEmail;

    private Intermediary intermediary;

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getPublicEmail() {
        return publicEmail;
    }

    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail;
    }

    @Override
    public Intermediary getIntermediary() {
        return intermediary;
    }

    @Override
    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }
}
