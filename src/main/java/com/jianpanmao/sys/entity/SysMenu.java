package com.jianpanmao.sys.entity;

import com.jianpanmao.common.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class SysMenu extends BaseEntity implements Serializable {
    //
    private Integer menuId;

    //菜单名称
    @NotNull(message = "菜单名称不能为空！")
    private String menuName;

    //父级菜单
    private Integer menuParentId;

    //url
    private String menuUrl;

    //权限码
    private String menuPrmission;

    //排序
    private Integer menuSortd;

    //是否显示1:显示，0不显示
    //@NotNull(message = "menuDisplay不能为空！")
    private Byte menuDisplay;


    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    private List<SysMenu> children=new ArrayList<>();

    //菜单图标
    private String icon;

    private static final long serialVersionUID = 1L;

    String order;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    String path;

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


    public static void r(SysMenu m, List<Integer> ids){
        ids.add(m.getMenuId());
        if(m.getChildren().size()>0){
            for (SysMenu sysMenu : m.getChildren()) {
                r(sysMenu,ids);
            }
        }
    }
}