package com.we.fc.clues.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.clues.entity.Clues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zdc
 * @since 2018-04-05 21:56
 */
@Controller
@RequestMapping("clues")
public class CluesController extends BaseController<Clues> {
    @Override
    public BaseService<Clues> getService() {
        return null;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "clues/index";
    }

    @GetMapping("detail")
    public String log(Integer menuId) {
        return "clues/detail";
    }
}
