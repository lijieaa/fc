package com.jianpanmao.sys.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class SysRoleMenu implements Serializable {
    //
    @NotNull(message = "roleId不能为空！")
    private Integer roleId;

    //
    @NotNull(message = "menuId不能为空！")
    private Integer menuId;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}