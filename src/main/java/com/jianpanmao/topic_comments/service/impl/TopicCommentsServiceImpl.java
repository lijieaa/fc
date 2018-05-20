package com.jianpanmao.topic_comments.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.topic_comments.dao.TopicCommentsMapper;
import com.jianpanmao.topic_comments.entity.*;
import com.jianpanmao.topic_comments.dto.*;
import com.jianpanmao.topic_comments.service.TopicCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TopicCommentsServiceImpl extends BaseServiceImpl<TopicComments, TopicCommentsExample, TopicCommentsDto, Integer> implements TopicCommentsService {

    @Autowired
    TopicCommentsMapper dao;

    @Override
    public int add(TopicComments record) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        record.setUser(user);
        return dao.insert(record);
    }
}