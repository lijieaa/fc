package com.we.fc.statistics.web;

import com.we.fc.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-05 18:05
 */

@Controller
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired private MenuService menuService;

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", menuService.findById(menuId));
        return "sys/statistics/index";
    }
}
