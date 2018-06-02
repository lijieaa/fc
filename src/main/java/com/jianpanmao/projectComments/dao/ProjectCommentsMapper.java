package com.jianpanmao.projectComments.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.projectComments.dto.ProjectCommentsDto;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.projectComments.entity.ProjectCommentsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectCommentsMapper extends BaseDao<ProjectComments, ProjectCommentsExample, ProjectCommentsDto, Integer> {
    List<ProjectComments> projectTopComments(Integer projectCommentsId);
    Integer topCommentsUnderCount(Integer projectCommentsId);
    Integer commentsCount(Integer projectId);
}