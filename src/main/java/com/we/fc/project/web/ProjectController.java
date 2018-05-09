package com.we.fc.project.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.project.dao.ProjectMapper;
import com.we.fc.project.entity.Project;
import com.we.fc.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper dao;

    @Override
    public BaseService<Project> getService() {
        return projectService;
    }

    @GetMapping("index")
    public String index(Integer menuId, Model model) {
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "project/index";
    }

    @GetMapping("byIdStatus")
    public Project selectByIdStatus(Integer id, Byte statusId) {
        return dao.selectByIdStatus(id, statusId);
    }


}
