package com.jianpanmao.common.utils;

import com.jianpanmao.sys.entity.SysMenu;


import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    public static List<SysMenu> buildByRecursive(List<SysMenu> menus) {

        List<SysMenu> trees = new ArrayList<SysMenu>();
        for (SysMenu menu : menus) {
            if ((menu.getMenuParentId()==0)) {
                findChildren(menu,menus,trees);
            }
        }
        return trees;
    }


    private static void findChildren(SysMenu menu,List<SysMenu> menus,List<SysMenu> trees) {
        trees.add(menu);
        //boolean flag=false;
        for (SysMenu m : menus) {

            if(menu.getMenuId().equals(m.getMenuParentId())) {
                findChildren(m,menus,trees);
                //flag=true;
            }/*else {
                if(flag==true) {
                    break;
                }
            }*/
        }

    }
}
