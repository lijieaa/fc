package com.we.fc.menu.utils;

import com.we.fc.menu.entity.Menu;

import java.util.*;

/**
 * @author zdc
 * @since 2018-03-31 12:51
 */

public class MenuUtils {

    // 获取顶级菜单
    public static Set<Menu> getTopMenus(Set<Menu> set){
        Set<Menu> result = new TreeSet<>();
        for(Menu menu : set){
            if(menu.getParent().getId().equals(0)){
                result.add(menu);
            }
        }
        return result;
    }
    public static Set<Menu> getChildren(Set<Menu> top, Set<Menu> all){
        for (Menu menu : top){
            for(Menu m : all){
                if(m.getParent().getId().equals(menu.getId())){
                    if(m.getUrl() != null && m.getUrl().length() > 0){
                        m.setUrl(m.getUrl() + "?menuId=" + m.getId());
                    }
                    menu.getChildren().add(m);
                }
            }
        }
        return top;
    }

    public static Set<Menu> getLevelMenu(Set<Menu> set){
        Set<Menu> menuSet = getChildren(getTopMenus(set), set);
        for(Menu menu : menuSet){
            if(menu.getChildren().size() == 0){
                menu.setUrl(menu.getUrl() + "?menuId=" + menu.getId());
            }
        }
        return menuSet;
    }
}
