package com.we.fc.wechat.entity;

import com.we.fc.base.BaseEntity;

/**
 * @author zdc
 * @since 2018-04-13 21:29
 */

public class WxUserOpenId extends BaseEntity{

    private String openId;

    private WxPublic wxPublic;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public WxPublic getWxPublic() {
        return wxPublic;
    }

    public void setWxPublic(WxPublic wxPublic) {
        this.wxPublic = wxPublic;
    }

    public WxUserOpenId(String openId, WxPublic wxPublic) {
        this.openId = openId;
        this.wxPublic = wxPublic;
    }
}
