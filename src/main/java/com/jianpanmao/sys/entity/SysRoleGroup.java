package com.jianpanmao.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class SysRoleGroup implements Serializable {
    //
    private Integer roleId;

    //
    @NotNull(message = "角色组不能为空！")
    private String roleName;

    //

    private Integer intermediaryId;

    //创建时间
    private Date roleGroupCreateTime;

    //更新时间
    private Date roleGroupUpdateTime;

    //
    private Integer isDel;

    private static final long serialVersionUID = 1L;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", roleGroupCreateTime=").append(roleGroupCreateTime);
        sb.append(", roleGroupUpdateTime=").append(roleGroupUpdateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public List<SysRole> getChildren() {
        return children;
    }

    public void setChildren(List<SysRole> children) {
        this.children = children;
    }

    private List<SysRole> children=new ArrayList<>();
}