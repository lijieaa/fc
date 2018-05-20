package com.jianpanmao.wechat.api.request;

/**
 * @author zdc
 * @since 2018-05-01 21:56
 */

public class MaterialRequest {

    private String type;

    private Integer offset;

    private Integer count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public MaterialRequest(String type, Integer offset, Integer count) {
        this.type = type;
        this.offset = offset;
        this.count = count;
    }

    public MaterialRequest(){}
}
