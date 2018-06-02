package com.jianpanmao.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class SysRoleGroup implements Serializable {
    //
    private Integer roleGroupId;

    //组名称
    @NotNull(message = "角色组名称不能为空！")
    private String roleGroupName;

    //
    private Integer intermediaryId;

    //创建时间
    private Date roleGroupCreateTime;

    //更新时间
    private Date roleGroupUpdateTime;

    private static final long serialVersionUID = 1L;


    public Integer getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(Integer roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    public String getRoleGroupName() {
        return roleGroupName;
    }

    public void setRoleGroupName(String roleGroupName) {
        this.roleGroupName = roleGroupName == null ? null : roleGroupName.trim();
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getRoleGroupCreateTime() {
        return roleGroupCreateTime;
    }

    public void setRoleGroupCreateTime(Date roleGroupCreateTime) {
        this.roleGroupCreateTime = roleGroupCreateTime;
    }

    public Date getRoleGroupUpdateTime() {
        return roleGroupUpdateTime;
    }

    public void setRoleGroupUpdateTime(Date roleGroupUpdateTime) {
        this.roleGroupUpdateTime = roleGroupUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleGroupId=").append(roleGroupId);
        sb.append(", roleGroupName=").append(roleGroupName);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", roleGroupCreateTime=").append(roleGroupCreateTime);
        sb.append(", roleGroupUpdateTime=").append(roleGroupUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    private List<SysRole> roles=new ArrayList<>();
}