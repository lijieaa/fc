package com.jianpanmao.project.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.entity.ProjectExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseDao<Project, ProjectExample, ProjectDto, Integer> {
    Project selectByIdStatus(@Param("id") Integer id, @Param("statusId") Byte statusId);
    List<Project> selectIdNameList();
}