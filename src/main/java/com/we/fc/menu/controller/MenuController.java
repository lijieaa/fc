package com.we.fc.menu.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

/**
 * 菜单控制器
 */
@Controller
@RequestMapping("sys/menu")
public class MenuController extends BaseController<Menu> {

    @Autowired
    MenuService menuService;

    @Override
    public BaseService<Menu> getService() {
        return menuService;
    }

    @RequestMapping("index")
    public String index(){

        return  "sys/menu/index";
    }


    @RequestMapping("menu_all")
    @ResponseBody
    public List<Menu> menuAll(){
        List<Menu> menus = menuService.selectAll(null);
        return  menus;
    }


}
