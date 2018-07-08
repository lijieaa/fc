package com.jianpanmao.contacts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Contacts implements Serializable {
    //
    private Integer conId;

    //联系人姓名
    @NotNull(message = "conName不能为空！")
    private String conName;

    //联系人电话
    @NotNull(message = "conTel不能为空！")
    private String conTel;

    //联系人qq
    private String conQq;

    //联系人微信
    private String conWechat;

    //联系人邮箱
    private String conEmail;

    //客户外键
    private Integer cusId;

    //中间商外键
    private Integer intermediaryId;

    //创建时间
    private Date conCreateTime;

    //最后更新时间
    private Date conUpdateTime;

    //角色外键
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel == null ? null : conTel.trim();
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq == null ? null : conQq.trim();
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat == null ? null : conWechat.trim();
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail == null ? null : conEmail.trim();
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getConCreateTime() {
        return conCreateTime;
    }

    public void setConCreateTime(Date conCreateTime) {
        this.conCreateTime = conCreateTime;
    }

    public Date getConUpdateTime() {
        return conUpdateTime;
    }

    public void setConUpdateTime(Date conUpdateTime) {
        this.conUpdateTime = conUpdateTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", conId=").append(conId);
        sb.append(", conName=").append(conName);
        sb.append(", conTel=").append(conTel);
        sb.append(", conQq=").append(conQq);
        sb.append(", conWechat=").append(conWechat);
        sb.append(", conEmail=").append(conEmail);
        sb.append(", cusId=").append(cusId);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", conCreateTime=").append(conCreateTime);
        sb.append(", conUpdateTime=").append(conUpdateTime);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}