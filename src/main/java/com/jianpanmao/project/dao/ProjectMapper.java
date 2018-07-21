package com.jianpanmao.project.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.project.dto.ProjectCustomer;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.entity.ProjectExample;
import com.jianpanmao.sys.dto.ContactsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseDao<Project, ProjectExample, ProjectDto, Integer> {
    Project selectByIdStatus(@Param("id") Integer id, @Param("statusId") Byte statusId);

    List<Project> selectIdNameList();

    void updateProjectStatus(Integer projectId);

    void addProjectUser(List id);

    void addContacts(List id);

    void deleteProjectUser(Integer pId);

    void deleteProjectContacts(Integer pId);

    List<ContactsDto> projectChargeUser(Integer pId);

    List<ProjectCustomer> projectCustomers(Integer pId);
}