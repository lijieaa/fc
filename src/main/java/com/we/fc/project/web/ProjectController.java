package com.we.fc.project.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.project.dao.ProjectMapper;
import com.we.fc.project.entity.Project;
import com.we.fc.project.service.ProjectService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @Override
    protected ResponseEntity hookExist(Project project) {
        return null;
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

    @Override
    public ResponseEntity add(@Valid @RequestBody Project project, BindingResult result, HttpSession session) {
            ResponseEntity responseEntity = new ResponseEntity();
            if (result.hasErrors()) {
                responseEntity.setStatus("500");
                responseEntity.setMessages("验证失败");
                responseEntity.setData(result.getAllErrors());
                return responseEntity;
            }
            try {
                getService().insert(project);
                return responseEntity;
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                responseEntity.setStatus("500");
                responseEntity.setMessages("添加失败");
                return responseEntity;
            } catch (Exception e) {
                e.printStackTrace();
                responseEntity.setStatus("500");
                responseEntity.setMessages(e.getMessage());
                return responseEntity;
        }
    }
}
