package com.jianpanmao.projectAttach.controller;

import com.jianpanmao.projectAttach.dao.ProjectAttachDao;
import com.jianpanmao.projectAttach.entity.AttachType;
import com.jianpanmao.projectAttach.entity.PType;
import com.jianpanmao.projectAttach.entity.ProjectPtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayn on 2018/7/25.
 */
@RestController
@RequestMapping("/api/pa")
public class ProjectAttachController {

    @Autowired
    private ProjectAttachDao dao;

    /****
     * 资源树
     */
    @GetMapping("pType")
    public List<PType> pTypeTree(){
        List<PType> pTypes = dao.allPtype();
        List<PType> tops = new ArrayList<>();
        for (PType p:pTypes){
            if (p.getpTypeParentId().intValue()==0){
                tops.add(p);
            }
        }
        pTypes.removeAll(tops);
return null;
    }

    /**
     * 新增项目文件分类
     */
    @PostMapping("pType")
    @Transactional
    public void addPType(String name,Integer parentId,Integer projectId){
        PType pType = new PType();
        pType.setpTypePName(name);
        pType.setpTypeParentId(parentId);
        if (pType.getpTypeParentId().intValue()==0){
            pType.setpTypePPath(",0,");
        }else {
            PType parent = dao.selectPType(pType.getpTypeParentId());
            String path = parent.getpTypePPath();
            path += path+parent.getpTypeId()+",";
            pType.setpTypePPath(path);
        }
        dao.insertPType(pType);
        //关联项目
        ProjectPtype projectPtype = new ProjectPtype();
        projectPtype.setProjectPTypePId(pType.getpTypeId());
        projectPtype.setProjectPTypeTId(projectId);
        dao.insertProjectPType(projectPtype);
    }

    /**
     * 修改项目文件分类名
     */
    @PutMapping("pType")
    public void updatePType(PType pType) {
        dao.updatePType(pType);
    }

    /**
     * 上传文件
     */
    @PostMapping("attachType")
    public void addAttachType(Integer pTypeId,Integer attachId){
        AttachType attachType = new AttachType();
        attachType.setAttachTypeTId(pTypeId);
        attachType.setAttachTypeAId(attachId);
        dao.insertAttachType(attachType);
    }

}
