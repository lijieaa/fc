package com.we.fc.statistics.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseEntity;
import com.we.fc.base.BaseService;
import com.we.fc.unit.ResponseEntity;
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
public class StatisticsController extends BaseController {

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "sys/statistics/index";
    }

    @Override
    public BaseService getService() {
        return null;
    }

    @Override
    protected ResponseEntity hookExist(BaseEntity baseEntity) {
        return null;
    }
}
