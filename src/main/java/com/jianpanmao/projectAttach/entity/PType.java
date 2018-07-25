package com.jianpanmao.projectAttach.entity;

/**
 * Created by mayn on 2018/7/25.
 */
public class PType {
    private Integer pTypeId;
    private String pTypePName;
    private Integer pTypeParentId;
    private String pTypePPath;

    public Integer getpTypeId() {
        return pTypeId;
    }

    public void setpTypeId(Integer pTypeId) {
        this.pTypeId = pTypeId;
    }

    public String getpTypePName() {
        return pTypePName;
    }

    public void setpTypePName(String pTypePName) {
        this.pTypePName = pTypePName;
    }

    public Integer getpTypeParentId() {
        return pTypeParentId;
    }

    public void setpTypeParentId(Integer pTypeParentId) {
        this.pTypeParentId = pTypeParentId;
    }

    public String getpTypePPath() {
        return pTypePPath;
    }

    public void setpTypePPath(String pTypePPath) {
        this.pTypePPath = pTypePPath;
    }
}
