package com.jianpanmao.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Project implements Serializable {
    //
    private Integer projectId;

    //项目名称
    @NotNull(message = "projectName不能为空！")
    private String projectName;

    //所属区域
    @NotNull(message = "areaId不能为空！")
    private Integer areaId;

    //项目联系人
    @NotNull(message = "projectContactUserId不能为空！")
    private Integer projectContactUserId;

    //线索创建人
    @NotNull(message = "projectCreateUserId不能为空！")
    private Integer projectCreateUserId;

    //业主联系人
    @NotNull(message = "projectOwnerContact不能为空！")
    private String projectOwnerContact;

    //业主电话
    @NotNull(message = "projectOwnerContactTel不能为空！")
    private String projectOwnerContactTel;

    //状态：0线索，1项目
    @NotNull(message = "projectStatus不能为空！")
    private Byte projectStatus;

    //创建时间
    @NotNull(message = "projectCreateTime不能为空！")
    private Date projectCreateTime;

    //更新时间
    @NotNull(message = "projectUpdateTime不能为空！")
    private Date projectUpdateTime;

    //
    @NotNull(message = "projectLogo不能为空！")
    private String projectLogo;

    //线索跟进状态：0已处理，1正在处理
    @NotNull(message = "projectTopicStatus不能为空！")
    private Byte projectTopicStatus;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getProjectContactUserId() {
        return projectContactUserId;
    }

    public void setProjectContactUserId(Integer projectContactUserId) {
        this.projectContactUserId = projectContactUserId;
    }

    public Integer getProjectCreateUserId() {
        return projectCreateUserId;
    }

    public void setProjectCreateUserId(Integer projectCreateUserId) {
        this.projectCreateUserId = projectCreateUserId;
    }

    public String getProjectOwnerContact() {
        return projectOwnerContact;
    }

    public void setProjectOwnerContact(String projectOwnerContact) {
        this.projectOwnerContact = projectOwnerContact == null ? null : projectOwnerContact.trim();
    }

    public String getProjectOwnerContactTel() {
        return projectOwnerContactTel;
    }

    public void setProjectOwnerContactTel(String projectOwnerContactTel) {
        this.projectOwnerContactTel = projectOwnerContactTel == null ? null : projectOwnerContactTel.trim();
    }

    public Byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Byte projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getProjectCreateTime() {
        return projectCreateTime;
    }

    public void setProjectCreateTime(Date projectCreateTime) {
        this.projectCreateTime = projectCreateTime;
    }

    public Date getProjectUpdateTime() {
        return projectUpdateTime;
    }

    public void setProjectUpdateTime(Date projectUpdateTime) {
        this.projectUpdateTime = projectUpdateTime;
    }

    public String getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo == null ? null : projectLogo.trim();
    }

    public Byte getProjectTopicStatus() {
        return projectTopicStatus;
    }

    public void setProjectTopicStatus(Byte projectTopicStatus) {
        this.projectTopicStatus = projectTopicStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", areaId=").append(areaId);
        sb.append(", projectContactUserId=").append(projectContactUserId);
        sb.append(", projectCreateUserId=").append(projectCreateUserId);
        sb.append(", projectOwnerContact=").append(projectOwnerContact);
        sb.append(", projectOwnerContactTel=").append(projectOwnerContactTel);
        sb.append(", projectStatus=").append(projectStatus);
        sb.append(", projectCreateTime=").append(projectCreateTime);
        sb.append(", projectUpdateTime=").append(projectUpdateTime);
        sb.append(", projectLogo=").append(projectLogo);
        sb.append(", projectTopicStatus=").append(projectTopicStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}