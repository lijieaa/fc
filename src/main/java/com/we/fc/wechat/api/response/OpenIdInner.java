package com.we.fc.wechat.api.response;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-14 11:56
 */

public class OpenIdInner {

    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}
