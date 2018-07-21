package com.jianpanmao.project.entity;

/**
 * Created by mayn on 2018/7/18.
 * 项目和 负责人中间表实体
 */
public class ProjectUser {
    private Integer projectUserId;
    private Integer projectUserPId;
    private Integer projectUserUserId;

    public Integer getProjectUserId() {
        return projectUserId;
    }

    public void setProjectUserId(Integer projectUserId) {
        this.projectUserId = projectUserId;
    }

    public Integer getProjectUserPId() {
        return projectUserPId;
    }

    public void setProjectUserPId(Integer projectUserPId) {
        this.projectUserPId = projectUserPId;
    }

    public Integer getProjectUserUserId() {
        return projectUserUserId;
    }

    public void setProjectUserUserId(Integer projectUserUserId) {
        this.projectUserUserId = projectUserUserId;
    }
}
