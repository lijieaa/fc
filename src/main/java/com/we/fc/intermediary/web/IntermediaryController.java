package com.we.fc.intermediary.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.intermediary.service.IntermediaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author zdc
 * @since 2018-04-05 21:40
 */
@Controller
@RequestMapping("intermediary")
public class IntermediaryController extends BaseController<Intermediary> {

    @Autowired
    IntermediaryService service;

    @GetMapping("detail")
    public String IntermediaryDetail(){
        return "intermediary/detail";
    }

    @Override
    public BaseService<Intermediary> getService() {
        return service;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }

}
