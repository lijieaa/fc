package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.DingtalkDeptMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.DingtalkDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingtalkDeptServiceImpl extends BaseServiceImpl<DingtalkDept,DingtalkDeptExample,DingtalkDeptDto,Integer> implements DingtalkDeptService {


    @Autowired
    DingtalkDeptMapper dingtalkDeptMapper;

    @Override
    public List<DingtalkDept> getAll(DingtalkDept record) {

        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        if(null==record){
            record=new DingtalkDept();
        }
        record.setIntermediaryId(user.getIntermediaryId());
        return super.getAll(record);
    }

    @Override
    public int add(DingtalkDept record) {

        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        record.setIntermediaryId(user.getIntermediaryId());

        if(null==record.getParentid()||record.getParentid()<=0){
            record.setParentid(0);
            record.setPath(0+"");
        }else{
            DingtalkDept pDept = this.get(record.getParentid());
            record.setPath(pDept.getPath()+","+pDept.getId());
        }
        return super.add(record);
    }

    @Override
    public int update(DingtalkDept record) {

        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        record.setIntermediaryId(cuser.getIntermediaryId());


        DingtalkDept dingtalkDept = this.get(record.getId());

        String oldPath=dingtalkDept.getPath();


        if(null==record.getParentid()||record.getParentid()<=0){
            record.setParentid(0);
            record.setPath(0+"");
        }else{
            DingtalkDept pDept = this.get(record.getParentid());
            record.setPath(pDept.getPath()+","+pDept.getId());
        }


        int update = super.update(record);


        DingtalkDept dept=new DingtalkDept();
        dept.setPath(dingtalkDept.getId() + "");

        List<DingtalkDept> dingtalkDepts = dingtalkDeptMapper.selectByPath(dept);

        for (DingtalkDept dingtalkDept1 : dingtalkDepts) {
            dingtalkDept1.setPath(dingtalkDept1.getPath().replace(oldPath,record.getPath()));
            dingtalkDept1.setIntermediaryId(cuser.getIntermediaryId());
            dingtalkDeptMapper.updatePath(dingtalkDept1);
        }


        return update;
    }

    @Override
    public List<DingtalkDept> selectByPath(String path) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        DingtalkDept dept=new DingtalkDept();
        dept.setPath(path);
        dept.setIntermediaryId(user.getIntermediaryId());
        return dingtalkDeptMapper.selectByPath(dept);
    }

    @Override
    public List<DingtalkDept> selectByLikeName(String deptName) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        DingtalkDept record=new DingtalkDept();
        record.setName(deptName);
        record.setIntermediaryId(user.getIntermediaryId());
        return dingtalkDeptMapper.selectByLikeName(record);
    }

    @Override
    public void sort(List<DingtalkDept> list) {
        for (DingtalkDept dept : list) {
            dingtalkDeptMapper.sort(dept);
        }
    }

    @Override
    public List<DingtalkDept> selectByParentId(Integer parentId) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        DingtalkDept record=new DingtalkDept();
        record.setParentid(parentId);
        record.setIntermediaryId(user.getIntermediaryId());
        return dingtalkDeptMapper.selectByParentId(record);
    }
}