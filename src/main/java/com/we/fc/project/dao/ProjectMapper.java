package com.we.fc.project.dao;

import com.we.fc.project.entity.Project;
import java.util.List;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    Project selectByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    List<Project> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Project record);
}