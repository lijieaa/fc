package com.we.fc.project.service;

import com.we.fc.base.BaseService;
import com.we.fc.project.entity.Project;

/**
 * Created by mayn on 2018/5/8.
 */
public interface ProjectService extends BaseService<Project> {
    Project selectByIdStatus(Integer id,Byte projectStatus);
}
