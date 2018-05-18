package com.we.fc.projectComments.entity;

import com.we.fc.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class ProjectComments extends BaseEntity implements Serializable  {

    private Integer projectCommentsParent;

    private String projectCommentsNickname;

    private Byte projectCommentsType;

    private Byte projectCommentsStatus;

    private Integer projectId;



    private String projectCommentsContent;

    private static final long serialVersionUID = 1L;


    public Integer getProjectCommentsParent() {
        return projectCommentsParent;
    }

    public void setProjectCommentsParent(Integer projectCommentsParent) {
        this.projectCommentsParent = projectCommentsParent;
    }

    public String getProjectCommentsNickname() {
        return projectCommentsNickname;
    }

    public void setProjectCommentsNickname(String projectCommentsNickname) {
        this.projectCommentsNickname = projectCommentsNickname == null ? null : projectCommentsNickname.trim();
    }

    public Byte getProjectCommentsType() {
        return projectCommentsType;
    }

    public void setProjectCommentsType(Byte projectCommentsType) {
        this.projectCommentsType = projectCommentsType;
    }

    public Byte getProjectCommentsStatus() {
        return projectCommentsStatus;
    }

    public void setProjectCommentsStatus(Byte projectCommentsStatus) {
        this.projectCommentsStatus = projectCommentsStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    public String getProjectCommentsContent() {
        return projectCommentsContent;
    }

    public void setProjectCommentsContent(String projectCommentsContent) {
        this.projectCommentsContent = projectCommentsContent == null ? null : projectCommentsContent.trim();
    }

}