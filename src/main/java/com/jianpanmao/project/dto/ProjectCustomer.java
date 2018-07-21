package com.jianpanmao.project.dto;

/**
 * Created by mayn on 2018/7/21.
 */
public class ProjectCustomer {
    private Integer conId;
    private String conName;
    private String conTel;
    private String conQQ;
    private String conWechat;
    private String conEmail;

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
        this.conName = conName;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    public String getConQQ() {
        return conQQ;
    }

    public void setConQQ(String conQQ) {
        this.conQQ = conQQ;
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
