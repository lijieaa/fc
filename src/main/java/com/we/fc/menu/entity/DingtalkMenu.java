package com.we.fc.menu.entity;

import java.io.Serializable;

public class DingtalkMenu implements Serializable {
    private Integer menuId;

    private String menuName;

    private Integer menuParentId;

    private String menuUrl;

    private String menuPrmission;

    private Integer menuSortd;

    private Byte menuDisplay;

    private String icon;

    private static final long serialVersionUID = 1L;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuPrmission() {
        return menuPrmission;
    }

    public void setMenuPrmission(String menuPrmission) {
        this.menuPrmission = menuPrmission == null ? null : menuPrmission.trim();
    }

    public Integer getMenuSortd() {
        return menuSortd;
    }

    public void setMenuSortd(Integer menuSortd) {
        this.menuSortd = menuSortd;
    }

    public Byte getMenuDisplay() {
        return menuDisplay;
    }

    public void setMenuDisplay(Byte menuDisplay) {
        this.menuDisplay = menuDisplay;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuParentId=").append(menuParentId);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", menuPrmission=").append(menuPrmission);
        sb.append(", menuSortd=").append(menuSortd);
        sb.append(", menuDisplay=").append(menuDisplay);
        sb.append(", icon=").append(icon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}