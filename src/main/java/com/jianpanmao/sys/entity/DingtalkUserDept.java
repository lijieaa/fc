package com.jianpanmao.sys.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class DingtalkUserDept implements Serializable {
    //用户ID
    private Integer userId;

    //部门ID
    private Integer deptId;

    //用户在某个部门里的排序字段
    private Integer order;

    private static final long serialVersionUID = 1L;


    public DingtalkUserDept(Integer userId, Integer deptId) {
        this.userId = userId;
        this.deptId = deptId;
    }

    public DingtalkUserDept() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", deptId=").append(deptId);
        sb.append(", order=").append(order);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}