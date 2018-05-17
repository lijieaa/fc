package com.we.fc.projectComments.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.projectComments.dao.ProjectCommentsMapper;
import com.we.fc.projectComments.entity.ProjectComments;
import com.we.fc.projectComments.service.ProjectCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/5/17.
 */
@Service
public class ProjectCommentsImpl extends BaseServiceImpl<ProjectComments> implements ProjectCommentsService {

    @Autowired
    private ProjectCommentsMapper dao;

    @Override
    public BaseDao<ProjectComments> getDao() {
        return dao;
    }
}
