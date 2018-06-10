package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.ConLabMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.ConLabService;
import com.jianpanmao.sys.service.ExtConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ExtConLabServiceImpl extends BaseServiceImpl<ExtConLab,ExtConLabExample,ExtConLabDto,Integer> implements ExtConLabService {

    @Autowired
    ConLabMapper conLabMapper;


    @Override
    public int remove(Integer TId) {
        conLabMapper.deleteByLabId(TId);
        return super.remove(TId);
    }

    @Override
    public int add(ExtConLab record) {
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setIntermediaryId(cuser.getIntermediaryId());
        return super.add(record);
    }
}