package com.jianpanmao.project.entity;

/**
 * Created by mayn on 2018/7/18.
 * 项目和客户中间表实体
 */
public class ProjectContacts {
    private Integer projectContactsId;
    private Integer projectContactsPId;
    private Integer projectContactsCId;

    public Integer getProjectContactsId() {
        return projectContactsId;
    }

    public void setProjectContactsId(Integer projectContactsId) {
        this.projectContactsId = projectContactsId;
    }

    public Integer getProjectContactsPId() {
        return projectContactsPId;
    }

    public void setProjectContactsPId(Integer projectContactsPId) {
        this.projectContactsPId = projectContactsPId;
    }

    public Integer getProjectContactsCId() {
        return projectContactsCId;
    }

    public void setProjectContactsCId(Integer projectContactsCId) {
        this.projectContactsCId = projectContactsCId;
    }
}
