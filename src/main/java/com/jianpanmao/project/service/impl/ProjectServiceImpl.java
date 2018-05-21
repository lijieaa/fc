package com.jianpanmao.project.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.*;
import com.jianpanmao.project.dto.*;
import com.jianpanmao.project.service.ProjectService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project,ProjectExample,ProjectDto,Integer> implements ProjectService {

    @Autowired
    private ProjectMapper dao;

    @Override
    public int add(Project record) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setProjectCreateUser(user);
        return dao.insert(record);
    }
}