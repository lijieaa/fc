package com.we.fc.role.group.entity;


import com.we.fc.base.BaseEntity;
import com.we.fc.role.entity.Role;

import java.util.List;

/**
 * 角色组
 * @author zdc
 * @since 2018-03-27 22:28
 */
public class RoleGroup extends BaseEntity {

    // 角色组名称
    private String name;

    // 角色列表
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
