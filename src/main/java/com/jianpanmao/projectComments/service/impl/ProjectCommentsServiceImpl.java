package com.jianpanmao.projectComments.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.notice.dao.NoticeMapper;
import com.jianpanmao.notice.entity.Notice;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.projectComments.dao.ProjectCommentsMapper;
import com.jianpanmao.projectComments.entity.*;
import com.jianpanmao.projectComments.dto.*;
import com.jianpanmao.projectComments.service.ProjectCommentsService;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectCommentsServiceImpl extends BaseServiceImpl<ProjectComments, ProjectCommentsExample, ProjectCommentsDto, Integer> implements ProjectCommentsService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    @Transactional
    public int add(ProjectComments record) {
        //添加评论
        DingtalkUser user = UserUtils.getUser();
        Project project = projectMapper.selectByPrimaryKey(record.getProjectId());
        record.setUser(user);
        record.setProjectCommentsStatus(project.getProjectStatus());
        record.setProjectCommentsType(new Byte("0"));
        Integer commentsId = super.add(record);
        //添加通知
        Notice notice = new Notice();
        //评论项目 获取项目创建人id
        if (record.getProjectCommentsParent().intValue()==0){
            notice.setNoticeBeUser(project.getProjectCreateUser());
            notice.setProject(project);
        }else {
            //回复评论  获取 回复的那条评论的人
            ProjectComments pc = super.get(record.getProjectCommentsParent());
            notice.setNoticeBeUser(pc.getUser());
            notice.setNoticeBeComments(pc);
        }
        notice.setNoticeComments(super.get(commentsId));
        notice.setNoticeUser(user);
        notice.setNoticeIscheck(0);
        noticeMapper.add(notice);

        return commentsId;
    }
}