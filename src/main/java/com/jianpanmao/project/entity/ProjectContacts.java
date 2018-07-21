package com.jianpanmao.project.entity;

/**
 * Created by mayn on 2018/7/18.
 * 项目和客户中间表实体
 */
public class ProjectContacts {
    private Integer projectContactsId;
    private Integer projectContactsPid;
    private Integer projectContactsCid;

    public Integer getProjectContactsId() {
        return projectContactsId;
    }

    public void setProjectContactsId(Integer projectContactsId) {
        this.projectContactsId = projectContactsId;
    }

    public Integer getProjectContactsPid() {
        return projectContactsPid;
    }

    public void setProjectContactsPid(Integer projectContactsPid) {
        this.projectContactsPid = projectContactsPid;
    }

    public Integer getProjectContactsCid() {
        return projectContactsCid;
    }

    public void setProjectContactsCid(Integer projectContactsCid) {
        this.projectContactsCid = projectContactsCid;
    }
}
