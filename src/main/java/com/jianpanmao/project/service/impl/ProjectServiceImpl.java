package com.jianpanmao.project.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.*;
import com.jianpanmao.project.dto.*;
import com.jianpanmao.project.service.ProjectService;
import com.jianpanmao.projectComments.dao.ProjectCommentsMapper;
import com.jianpanmao.sys.dto.ContactsDto;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, ProjectExample, ProjectDto, Integer> implements ProjectService {

    @Autowired
    private ProjectMapper dao;

    @Autowired
    private ProjectCommentsMapper projectCommentsMapper;

    @Override
    public Project get(Integer TId) {
        Project project = super.get(TId);
        Integer count = projectCommentsMapper.commentsCount(TId);
        List<ContactsDto> contactsDtos = dao.projectChargeUser(TId);
        List<ProjectCustomer> customers = dao.projectCustomers(TId);
        project.setProjectChargeUser(contactsDtos);
        project.setProjectCustomers(customers);
        project.setCount(count);
        return project;
    }

    @Override
    @Transactional
    public int removeBatch(Integer[] ids) {
        for (Integer id : ids) {
            dao.deleteProjectUser(id);
            dao.deleteProjectContacts(id);
        }
        return super.removeBatch(ids);
    }
    @Override
    @Transactional
    public int remove(Integer TId) {
        dao.deleteProjectUser(TId);
        dao.deleteProjectContacts(TId);
        return super.remove(TId);
    }

    @Override
    @Transactional
    public int update(Project record) {
        dao.deleteProjectUser(record.getProjectId());
        dao.deleteProjectContacts(record.getProjectId());
        int c = super.update(record);
        if (null != record.getProjectUser() && record.getProjectUser().length() > 0) {
            addProjectUser(record.getProjectUser(), record);
        }
        if (null != record.getProjectContacts() && record.getProjectContacts().length() > 0) {
            addProjectContacts(record.getProjectContacts(), record);
        }
        return c;
    }

    @Override
    @Transactional
    public int add(Project record) {

        DingtalkUser user = UserUtils.getUser();
        record.setProjectCreateUser(user);
        record.setIntermediary(user.getIntermediary());
        int c = dao.insert(record);
        if (null != record.getProjectUser() && record.getProjectUser().length() > 0) {
            addProjectUser(record.getProjectUser(), record);
        }
        if (null != record.getProjectContacts() && record.getProjectContacts().length() > 0) {
            addProjectContacts(record.getProjectContacts(), record);
        }
        return c;
    }

    //添加项目负责人
    void addProjectUser(String ids, Project project) {
        List<ProjectUser> projectUsers = new ArrayList<>();
        String idStr[] = ids.split(",");
        for (String uId : idStr) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectUserPId(project.getProjectId());
            projectUser.setProjectUserUserId(Integer.valueOf(uId));
            projectUsers.add(projectUser);
        }
        dao.addProjectUser(projectUsers);
    }

    //添加项目客户
    void addProjectContacts(String ids, Project project) {
        List<ProjectContacts> projectContactses = new ArrayList<>();
        String idStr[] = ids.split(",");
        for (String cId : idStr) {
            ProjectContacts projectContacts = new ProjectContacts();
            projectContacts.setProjectContactsPId(project.getProjectId());
            projectContacts.setProjectContactsCId(Integer.valueOf(cId));
            projectContactses.add(projectContacts);
        }
        dao.addContacts(projectContactses);
    }
}