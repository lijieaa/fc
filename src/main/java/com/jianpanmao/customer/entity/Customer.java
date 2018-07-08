package com.jianpanmao.customer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Customer implements Serializable {
    //主键
    private Integer cusId;

    private String cusComName;


    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @NotNull(message = "客户名称不能为空！")
    private String cusName;


    //联系人公司电话
    private String cusComTel;

    //联系人公司邮箱
    private String cusComEmail;

    //联系公司地址
    private String cusComAdr;

    //
    private Integer intermediaryId;

    //创建时间
    private Date cusCreateTime;

    //最后更新时间
    private Date cusUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusComName() {
        return cusComName;
    }

    public void setCusComName(String cusComName) {
        this.cusComName = cusComName == null ? null : cusComName.trim();
    }

    public String getCusComTel() {
        return cusComTel;
    }

    public void setCusComTel(String cusComTel) {
        this.cusComTel = cusComTel == null ? null : cusComTel.trim();
    }

    public String getCusComEmail() {
        return cusComEmail;
    }

    public void setCusComEmail(String cusComEmail) {
        this.cusComEmail = cusComEmail == null ? null : cusComEmail.trim();
    }

    public String getCusComAdr() {
        return cusComAdr;
    }

    public void setCusComAdr(String cusComAdr) {
        this.cusComAdr = cusComAdr == null ? null : cusComAdr.trim();
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getCusCreateTime() {
        return cusCreateTime;
    }

    public void setCusCreateTime(Date cusCreateTime) {
        this.cusCreateTime = cusCreateTime;
    }

    public Date getCusUpdateTime() {
        return cusUpdateTime;
    }

    public void setCusUpdateTime(Date cusUpdateTime) {
        this.cusUpdateTime = cusUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cusId=").append(cusId);
        sb.append(", cusComName=").append(cusComName);
        sb.append(", cusComTel=").append(cusComTel);
        sb.append(", cusComEmail=").append(cusComEmail);
        sb.append(", cusComAdr=").append(cusComAdr);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", cusCreateTime=").append(cusCreateTime);
        sb.append(", cusUpdateTime=").append(cusUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}