package com.we.fc.wechat.entity;

import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.User;

/**
 * @author zdc
 * @since 2018-04-08 21:27
 */

public class WxToken extends BaseEntity{

    private String appId;

    private String appSecret;

    private User user;

    private String accessToken;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
