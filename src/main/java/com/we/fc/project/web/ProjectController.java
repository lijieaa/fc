package com.we.fc.project.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.project.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zdc
 * @since 2018-04-05 21:43
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController<Project> {
    @Override
    public BaseService<Project> getService() {
        return null;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "project/index";
    }
}
