package com.jianpanmao.sys.dto;

/**
 * Created by mayn on 2018/7/14.
 */
public class DeptTreeUser {
    private Integer userId;
    private String name;
    private Integer parentId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
