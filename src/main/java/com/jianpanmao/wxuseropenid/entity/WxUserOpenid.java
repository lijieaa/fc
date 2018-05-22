package com.jianpanmao.wxuseropenid.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class WxUserOpenid implements Serializable {
    //
    private Integer openidId;

    //openid
    @NotNull(message = "openid不能为空！")
    private String openid;

    //所属公众号
    @NotNull(message = "publicId不能为空！")
    private Integer publicId;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getOpenidId() {
        return openidId;
    }

    public void setOpenidId(Integer openidId) {
        this.openidId = openidId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getPublicId() {
        return publicId;
    }

    public void setPublicId(Integer publicId) {
        this.publicId = publicId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", openidId=").append(openidId);
        sb.append(", openid=").append(openid);
        sb.append(", publicId=").append(publicId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}