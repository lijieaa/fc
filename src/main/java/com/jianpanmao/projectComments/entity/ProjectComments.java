package com.jianpanmao.projectComments.entity;

import com.jianpanmao.sys.entity.DingtalkUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ProjectComments implements Serializable {
    //
    private Integer projectCommentsId;

    //上级评论
    private Integer projectCommentsParent;

    //评论人
    private DingtalkUser user;

    //评论类型：0内部评论，1外部评论
    private Byte projectCommentsType;

    //评论状态：0线索，1项目
    private Byte projectCommentsStatus;

    //项目ID
    @NotNull(message = "projectId不能为空！")
    private Integer projectId;

    private Integer projectTopCommentsId;

    //创建时间
    private Date projectCommentsCreateTime;

    //更新时间
    private Date projectCommentsUpdateTime;

    //评论内容
    @NotNull(message = "projectCommentsContent不能为空！")
    private String projectCommentsContent;

    private Integer count;

    private String parentName;//上级评论人

    private List<ProjectComments> children;


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getProjectTopCommentsId() {
        return projectTopCommentsId;
    }

    public void setProjectTopCommentsId(Integer projectTopCommentsId) {
        this.projectTopCommentsId = projectTopCommentsId;
    }

    public List<ProjectComments> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectComments> children) {
        this.children = children;
    }

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getProjectCommentsId() {
        return projectCommentsId;
    }

    public void setProjectCommentsId(Integer projectCommentsId) {
        this.projectCommentsId = projectCommentsId;
    }

    public Integer getProjectCommentsParent() {
        return projectCommentsParent;
    }

    public void setProjectCommentsParent(Integer projectCommentsParent) {
        this.projectCommentsParent = projectCommentsParent;
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
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

    public Date getProjectCommentsCreateTime() {
        return projectCommentsCreateTime;
    }

    public void setProjectCommentsCreateTime(Date projectCommentsCreateTime) {
        this.projectCommentsCreateTime = projectCommentsCreateTime;
    }

    public Date getProjectCommentsUpdateTime() {
        return projectCommentsUpdateTime;
    }

    public void setProjectCommentsUpdateTime(Date projectCommentsUpdateTime) {
        this.projectCommentsUpdateTime = projectCommentsUpdateTime;
    }

    public String getProjectCommentsContent() {
        return projectCommentsContent;
    }

    public void setProjectCommentsContent(String projectCommentsContent) {
        this.projectCommentsContent = projectCommentsContent == null ? null : projectCommentsContent.trim();
    }

}