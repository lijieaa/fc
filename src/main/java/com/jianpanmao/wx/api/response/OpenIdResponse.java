package com.jianpanmao.wx.api.response;

/**
 * @author zdc
 * @since 2018-04-14 11:53
 */

public class OpenIdResponse {

    private Integer total;

    private Integer count;

    private String next_openid;

    private OpenIdInner data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public OpenIdInner getData() {
        return data;
    }

    public void setData(OpenIdInner data) {
        this.data = data;
    }
}
