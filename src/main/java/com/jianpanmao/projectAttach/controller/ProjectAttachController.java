package com.jianpanmao.projectAttach.controller;

import com.jianpanmao.attach.dao.AttachMapper;
import com.jianpanmao.attach.entity.Attach;
import com.jianpanmao.attach.service.AttachService;
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

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private AttachService attachService;

    /****
     * 资源树
     */
    @GetMapping("pType")
    public List<PType> pTypeTree(Integer pid){
        List<PType> pTypes = dao.projectPtype(pid);
        for (PType p:pTypes){
            setChildren(p,pTypes);
        }
        List<PType> tops = new ArrayList<>();
        for (PType p:pTypes){
            if (p.getpTypeParentId().intValue()==0){
                tops.add(p);
            }
        }
        return tops;

    }

    void setChildren(PType pType,List<PType> list){
        List<PType> children = new ArrayList<>();
        for (PType p:list){
            if (p.getpTypeParentId().intValue()==pType.getpTypeId()){
                children.add(p);
            }
        }
        pType.setChildren(children);
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
            path = path+parent.getpTypeId()+",";
            pType.setpTypePPath(path);
        }
        dao.insertPType(pType);
        //关联项目
        ProjectPtype projectPtype = new ProjectPtype();
        projectPtype.setProjectPTypePId(projectId);
        projectPtype.setProjectPTypeTId(pType.getpTypeId());
        dao.insertProjectPType(projectPtype);
    }

    /**
     * 修改项目文件分类名
     */
    @PutMapping("pType")
    public void updatePType(@RequestBody PType pType) {
        dao.updatePType(pType);
    }

    /**
     * 删除项目资源
     * @param pTypeId
     */
    @DeleteMapping("pType")
    @Transactional
    public void deletePtype(Integer pTypeId){
        PType p = dao.selectPType(pTypeId);
        //删除自身
        deleteOthers(pTypeId);
        //删除下级所有分类
        String path = p.getpTypePPath()+pTypeId+",";
        List<PType> pTypes = dao.underPType(path);
        for (PType pType:pTypes){
            deleteOthers(pType.getpTypeId());
        }
    }

    //删除分类和关联的数据
    private void deleteOthers(Integer id){
        //删除分类
        dao.deletePType(id);
        //删除分类和项目的关联
        dao.deleteProjectPType(id);

        //删除资源
        List<Attach> attaches = attachMapper.typeAttach(id);
        Integer aid[] =  new Integer[attaches.size()];
        for (int i = 0; i < attaches.size(); i++) {
            aid[i] = attaches.get(i).getId();
        }
        attachService.removeBatch(aid);
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

    /**
     * 查询分类下资源
     */
    @GetMapping("attachType")
    public List<Attach> attachType(Integer tid){
        return attachMapper.typeAttach(tid);
    }

}
