package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.ExtConLabMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.LabGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabGroupServiceImpl extends BaseServiceImpl<LabGroup,LabGroupExample,LabGroupDto,Integer> implements LabGroupService {

    @Autowired
    ExtConLabMapper extConLabMapper;


    @Override
    public int remove(Integer TId) {
        extConLabMapper.deleteByGroupId(TId);
        return super.remove(TId);
    }

    @Override
    public List<LabGroup> getAll(LabGroup record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LabGroup group=new LabGroup();
        group.setIntermediaryId(cuser.getIntermediaryId());
        return super.getAll(group);
    }

    @Override
    public int add(LabGroup record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.add(record);
    }

}