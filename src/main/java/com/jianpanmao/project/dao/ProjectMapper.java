package com.jianpanmao.project.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.entity.ProjectExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper extends BaseDao<Project, ProjectExample, ProjectDto, Integer> {
}