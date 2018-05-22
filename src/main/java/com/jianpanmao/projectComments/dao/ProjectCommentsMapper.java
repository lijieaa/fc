package com.jianpanmao.projectComments.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.projectComments.dto.ProjectCommentsDto;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.projectComments.entity.ProjectCommentsExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectCommentsMapper extends BaseDao<ProjectComments, ProjectCommentsExample, ProjectCommentsDto, Integer> {
}