package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.ExtConMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.ConLabService;
import com.jianpanmao.sys.service.ExtConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtConServiceImpl extends BaseServiceImpl<ExtCon,ExtConExample,ExtConDto,Integer> implements ExtConService {

    @Autowired
    ConLabService conLabService;



    @Autowired
    ExtConMapper extConMapper;

    @Override
    public int add(ExtCon record) {

        int add = super.add(record);

        List<ExtConLab> labs = record.getLabs();
        for (ExtConLab lab : labs) {
            ConLab cl=new ConLab(lab.getId(),record.getId());
            conLabService.add(cl);
        }

        return add;
    }

    @Override
    public int update(ExtCon record) {

        return super.update(record);
    }

    @Override
    public List<ExtCon> selectByLabId(Integer labId) {
        return extConMapper.selectByLabId(labId);
    }
}