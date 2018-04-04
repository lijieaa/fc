package com.we.fc.role.entity;


import com.we.fc.base.BaseEntity;
import com.we.fc.menu.entity.Menu;
import com.we.fc.role.group.entity.RoleGroup;

import java.util.List;

/**
 * 角色
 * @author zdc
 * @since 2018-03-27 22:27
 */

public class Role extends BaseEntity {

    // 角色名称
    private String name;

    // 所以角色组
    private RoleGroup roleGroup;

    // 权限
    private List<Menu> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleGroup getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(RoleGroup roleGroup) {
        this.roleGroup = roleGroup;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
