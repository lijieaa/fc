package com.we.fc.menu.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.menu.entity.DingtalkMenu;
import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.DingtalkMenuService;
import com.we.fc.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单控制器
 */
@Controller
@RequestMapping("ding_talk_menu")
public class DingtalkMenuController extends BaseController<DingtalkMenu> {

    @Autowired
    DingtalkMenuService dingtalkMenuService;

    @Override
    public BaseService<DingtalkMenu> getService() {
        return dingtalkMenuService;
    }

    @RequestMapping("index")
    public String index(){
        return  "sys/menu/index";
    }


}
