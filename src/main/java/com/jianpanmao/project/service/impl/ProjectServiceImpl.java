package com.jianpanmao.project.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.*;
import com.jianpanmao.project.dto.*;
import com.jianpanmao.project.service.ProjectService;
import com.jianpanmao.projectComments.dao.ProjectCommentsMapper;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, ProjectExample, ProjectDto, Integer> implements ProjectService {

    @Autowired
    private ProjectMapper dao;

    @Autowired
    private ProjectCommentsMapper projectCommentsMapper;

    @Override
    public Project get(Integer TId) {
        Project project = super.get(TId);
        Integer count = projectCommentsMapper.commentsCount(TId);
        project.setCount(count);
        return project;
    }

    @Override
    public int add(Project record) {
        DingtalkUser user = UserUtils.getUser();
        record.setProjectCreateUser(user);
        return dao.insert(record);
    }
}