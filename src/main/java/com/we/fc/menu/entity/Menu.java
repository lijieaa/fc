package com.we.fc.menu.entity;


import com.we.fc.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * 菜单
 * @author zdc
 * @since 2018-03-30 20:37
 */
public class Menu extends BaseEntity implements Comparable<Menu>{

    // 菜单名称
    private String name;

    // 父组菜单
    private Menu parent;

    //url
    private String url;

    //权限
    private String permission;

    //排序
    private Integer sortd;

    //是否显示为菜单
    private Integer display;

    // 图标
    private String icon;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private Integer pid;

    // 子菜单
    private Set<Menu> children = new HashSet<>();

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSortd() {
        return sortd;
    }

    public void setSortd(Integer sortd) {
        this.sortd = sortd;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", sortd=" + sortd +
                ", display=" + display +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return this.getId().equals(((Menu)o).getId());
    }

    @Override
    public int hashCode() {
        return this.getId().intValue() * 31;
    }

    @Override
    public int compareTo(Menu o) {
        int s1 = this.getSortd().intValue();
        int s2 = o.getSortd().intValue();
        return s1 < s2 ? -1 : s1 == s2 ? 0 : 1;
    }
}
