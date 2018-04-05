package com.we.fc.intermediary.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zdc
 * @since 2018-04-05 21:40
 */
@Controller
@RequestMapping("intermediary")
public class IntermediaryController extends BaseController<Intermediary> {
    @Override
    public BaseService<Intermediary> getService() {
        return null;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }
}
