package com.we.fc.project.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.project.entity.Project;
import java.util.List;

public interface ProjectMapper extends BaseDao<Project>{

    Project selectByIdStatus(Integer id,Byte projectStatus);
}