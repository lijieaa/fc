package com.jianpanmao.project.dto;

import com.jianpanmao.area.entity.Area;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.sys.entity.DingtalkUser;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectDto {


    private DingtalkUser projectContactUser;

    private String projectOwnerContact;

    public String getProjectOwnerContact() {
        return projectOwnerContact;
    }

    public void setProjectOwnerContact(String projectOwnerContact) {
        this.projectOwnerContact = projectOwnerContact;
    }

    private Byte projectTopicStatus;

    public Byte getProjectTopicStatus() {
        return projectTopicStatus;
    }

    public void setProjectTopicStatus(Byte projectTopicStatus) {
        this.projectTopicStatus = projectTopicStatus;
    }

    private Date projectCreateTime;

    public Date getProjectCreateTime() {
        return projectCreateTime;
    }

    public void setProjectCreateTime(Date projectCreateTime) {
        this.projectCreateTime = projectCreateTime;
    }

    private Byte projectStatus;

    public Byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Byte projectStatus) {
        this.projectStatus = projectStatus;
    }

    private Area area;

    private String projectLogo;

    public String getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }

    private DingtalkUser projectCreateUser;

    private String projectOwnerContactTel;

    public String getProjectOwnerContactTel() {
        return projectOwnerContactTel;
    }

    public void setProjectOwnerContactTel(String projectOwnerContactTel) {
        this.projectOwnerContactTel = projectOwnerContactTel;
    }

    private Intermediary intermediary;

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    private String od;

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private Integer projectId;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    private Date projectUpdateTime;

    public Date getProjectUpdateTime() {
        return projectUpdateTime;
    }

    public void setProjectUpdateTime(Date projectUpdateTime) {
        this.projectUpdateTime = projectUpdateTime;
    }

    public DingtalkUser getProjectContactUser() {
        return projectContactUser;
    }

    public void setProjectContactUser(DingtalkUser projectContactUser) {
        this.projectContactUser = projectContactUser;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public DingtalkUser getProjectCreateUser() {
        return projectCreateUser;
    }

    public void setProjectCreateUser(DingtalkUser projectCreateUser) {
        this.projectCreateUser = projectCreateUser;
    }

}