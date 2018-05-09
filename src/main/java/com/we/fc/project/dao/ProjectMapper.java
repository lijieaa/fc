package com.we.fc.project.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.project.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProjectMapper extends BaseDao<Project>{

    Project selectByIdStatus(Integer id,Byte projectStatus);
}