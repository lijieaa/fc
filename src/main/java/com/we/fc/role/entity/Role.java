package com.we.fc.role.entity;


import com.we.fc.base.BaseEntity;
import com.we.fc.menu.entity.Menu;
import java.util.List;

/**
 * 角色
 * @author zdc
 * @since 2018-03-27 22:27
 */

public class Role extends BaseEntity {

    // 角色名称
    private String name;

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    private Integer intermediaryId;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private Integer pid;

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    private Integer isDel;

    // 权限
    private List<Menu> menus;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
