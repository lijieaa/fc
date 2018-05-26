package com.jianpanmao.topic.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.topic.dao.TopicMapper;
import com.jianpanmao.topic.entity.*;
import com.jianpanmao.topic.dto.*;
import com.jianpanmao.topic.service.TopicService;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic, TopicExample, TopicDto, Integer> implements TopicService {

    @Autowired
    private TopicMapper dao;

    @Override
    public int add(Topic record) {

        DingtalkUser user = UserUtils.getUser();

        record.setUser(user);
        return dao.insert(record);
    }
}