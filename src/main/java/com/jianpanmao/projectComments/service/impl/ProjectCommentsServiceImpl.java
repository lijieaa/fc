package com.jianpanmao.projectComments.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.projectComments.entity.*;
import com.jianpanmao.projectComments.dto.*;
import com.jianpanmao.projectComments.service.ProjectCommentsService;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectCommentsServiceImpl extends BaseServiceImpl<ProjectComments,ProjectCommentsExample,ProjectCommentsDto,Integer> implements ProjectCommentsService {
    @Autowired
    private ProjectMapper dao;
    @Override
    public int add(ProjectComments record) {
        DingtalkUser user = UserUtils.getUser();
        Project project = dao.selectByPrimaryKey(record.getProjectId());
        record.setProjectCommentsNickname(user.getName());
        record.setProjectCommentsStatus(project.getProjectStatus());
        record.setProjectCommentsType(new Byte("0"));
        return super.add(record);
    }
}