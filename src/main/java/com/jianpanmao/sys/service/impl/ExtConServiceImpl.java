package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.ExtConMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.ConLabService;
import com.jianpanmao.sys.service.ExtConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtConServiceImpl extends BaseServiceImpl<ExtCon,ExtConExample,ExtConDto,Integer> implements ExtConService {

    @Autowired
    ConLabService conLabService;



    @Autowired
    ExtConMapper extConMapper;

    @Override
    public int removeBatch(Integer[] ids) {
        //return super.removeBatch(ids);
        int remove=0;
        for (Integer id : ids) {
            remove = this.remove(id);
        }

        return remove;
    }

    @Override
    public int remove(Integer TId) {
        conLabService.remove(TId);
        return super.remove(TId);
    }

    @Override
    public int add(ExtCon record) {

        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        record.setIntermediaryId(user.getIntermediaryId());

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

        int remove = conLabService.remove(record.getId());

        List<ExtConLab> labs = record.getLabs();
        for (ExtConLab lab : labs) {
            ConLab cl=new ConLab(lab.getId(),record.getId());
            conLabService.add(cl);
        }

        return super.update(record);
    }

    @Override
    public List<ExtCon> selectByLabId(Integer labId) {
        return extConMapper.selectByLabId(labId);
    }
}