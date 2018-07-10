package com.jianpanmao.contacts.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Contact2Role implements Serializable {
    //
    private Integer conRol;

    //
    @NotNull(message = "conId不能为空！")
    private Integer conId;

    //
    @NotNull(message = "rolId不能为空！")
    private Integer rolId;

    private static final long serialVersionUID = 1L;

    String od;

    public Contact2Role(Integer conId, Integer rolId) {
        this.conId = conId;
        this.rolId = rolId;
    }

    public Contact2Role() {
    }

    public Integer getConRol() {
        return conRol;
    }

    public void setConRol(Integer conRol) {
        this.conRol = conRol;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", conRol=").append(conRol);
        sb.append(", conId=").append(conId);
        sb.append(", rolId=").append(rolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}