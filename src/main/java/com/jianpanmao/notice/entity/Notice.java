package com.jianpanmao.notice.entity;

import com.jianpanmao.project.entity.Project;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.sys.entity.DingtalkUser;

import java.util.Date;

/**
 * Created by mayn on 2018/6/10.
 */
public class Notice {
    private Integer noticeId;
    private DingtalkUser noticeBeUser;
    private DingtalkUser noticeUser;
    private ProjectComments noticeBeComments;
    private Project project;
    private ProjectComments noticeComments;
    private Integer noticeIscheck;
    private Date noticeCreateTime;
    private Date noticeUpdateTime;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public DingtalkUser getNoticeBeUser() {
        return noticeBeUser;
    }

    public void setNoticeBeUser(DingtalkUser noticeBeUser) {
        this.noticeBeUser = noticeBeUser;
    }

    public DingtalkUser getNoticeUser() {
        return noticeUser;
    }

    public void setNoticeUser(DingtalkUser noticeUser) {
        this.noticeUser = noticeUser;
    }

    public ProjectComments getNoticeBeComments() {
        return noticeBeComments;
    }

    public void setNoticeBeComments(ProjectComments noticeBeComments) {
        this.noticeBeComments = noticeBeComments;
    }

    public ProjectComments getNoticeComments() {
        return noticeComments;
    }

    public void setNoticeComments(ProjectComments noticeComments) {
        this.noticeComments = noticeComments;
    }

    public Integer getNoticeIscheck() {
        return noticeIscheck;
    }

    public void setNoticeIscheck(Integer noticeIscheck) {
        this.noticeIscheck = noticeIscheck;
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public Date getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    public void setNoticeUpdateTime(Date noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }
}
