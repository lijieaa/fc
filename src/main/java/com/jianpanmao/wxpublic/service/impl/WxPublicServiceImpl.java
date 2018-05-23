package com.jianpanmao.wxpublic.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.wxpublic.dao.WxPublicMapper;
import com.jianpanmao.wxpublic.entity.*;
import com.jianpanmao.wxpublic.dto.*;
import com.jianpanmao.wxpublic.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxPublicServiceImpl extends BaseServiceImpl<WxPublic,WxPublicExample,WxPublicDto,Integer> implements WxPublicService {

    @Autowired
    private WxPublicMapper wxPublicMapper;

    @Override
    public List<WxPublic> findByCompanyId(Integer companyId) {
        return wxPublicMapper.findByCompanyId(companyId);
    }
}