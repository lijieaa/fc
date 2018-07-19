package com.jianpanmao.project.entity;

import com.jianpanmao.area.entity.Area;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Project implements Serializable {
    //
    private Integer projectId;

    //项目名称
    @NotBlank(message = "线索或项目名称不能为空")
    @Size(min = 1, max = 50, message = "线索或项目名称在1-50个字符之间")
    private String projectName;

    //所属区域
    private @NotNull(message = "地区不能为空") Area area;

    //项目负责人id字符串
    private @NotNull(message = "负责人不能为空") String contacts;


    //客户 id字符串
    @NotBlank(message = "客户")
    private String projectOwnerContact;


    //状态：0线索，1项目
    @NotNull(message = "状态不能为空")
    private Byte projectStatus;

    //创建时间
    private Date projectCreateTime;

    //更新时间
    private Date projectUpdateTime;

    //
    @NotBlank(message = "logo不能为空")
    private String projectLogo;

    //线索跟进状态：0已处理，1正在处理
    private Byte projectTopicStatus;

    //中间商
    private Intermediary intermediary;

    //项目简介
    private String projectIntroduction;

    private DingtalkUser projectCreateUser;

    public DingtalkUser getProjectCreateUser() {
        return projectCreateUser;
    }

    public void setProjectCreateUser(DingtalkUser projectCreateUser) {
        this.projectCreateUser = projectCreateUser;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    private Integer count;

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    public String getProjectOwnerContact() {
        return projectOwnerContact;
    }

    public void setProjectOwnerContact(String projectOwnerContact) {
        this.projectOwnerContact = projectOwnerContact == null ? null : projectOwnerContact.trim();
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

}