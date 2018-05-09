package com.we.fc.project.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.project.dao.ProjectMapper;
import com.we.fc.project.entity.Project;
import com.we.fc.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/5/9.
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

    @Autowired
    ProjectMapper dao;

    @Override
    public BaseDao<Project> getDao() {
        return dao;
    }
}
