package com.we.fc.projectComments.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.projectComments.entity.ProjectComments;
import com.we.fc.projectComments.service.ProjectCommentsService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mayn on 2018/5/17.
 *
 */

@Controller
@RequestMapping("ProjectComments")
public class ProjectCommentsController extends BaseController<ProjectComments>{

    @Autowired
    private ProjectCommentsService service;


    @Override
    public BaseService<ProjectComments> getService() {
        return service;
    }

    @Override
    protected ResponseEntity hookExist(ProjectComments projectComments) {
        return null;
    }
}
