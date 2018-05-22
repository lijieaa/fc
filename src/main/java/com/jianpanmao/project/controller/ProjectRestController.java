package com.jianpanmao.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {


    @Autowired
    ProjectService projectService;

    @Autowired
    private ProjectMapper dao;

    @PreAuthorize("hasAuthority('project:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody Project entity) {
        return projectService.add(entity);
    }

    @PreAuthorize("hasAuthority('project:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return projectService.remove(id);
    }

    @PreAuthorize("hasAuthority('project:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return projectService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('project:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Project entity) {
        return projectService.update(entity);
    }

    @PreAuthorize("hasAuthority('project:view')")
    @RequestMapping(method = RequestMethod.GET)
    public Project get(@RequestParam("id") Integer id) {
        return projectService.get(id);
    }

    @PreAuthorize("hasAuthority('project:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       ProjectDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Project> list = projectService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Project> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
    @PreAuthorize("hasAuthority('project:view')")
    @GetMapping("byIdStatus")
    @ResponseBody
    public Project selectByIdStatus(Integer id, Byte statusId) {
        return dao.selectByIdStatus(id, statusId);
    }
}
