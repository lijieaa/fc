package com.jianpanmao.projectAttach.dao;

import com.jianpanmao.projectAttach.entity.AttachType;
import com.jianpanmao.projectAttach.entity.PType;
import com.jianpanmao.projectAttach.entity.ProjectPtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mayn on 2018/7/26.
 */
@Mapper
public interface ProjectAttachDao {
    Integer insertPType(PType pType);
    PType selectPType(Integer id);
    void updatePType(PType pType);

    List<PType> projectPtype(Integer pid);

    Integer insertProjectPType(ProjectPtype projectPtype);

    void insertAttachType(AttachType attachType);
}
