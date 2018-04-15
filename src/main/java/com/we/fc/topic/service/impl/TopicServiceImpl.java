package com.we.fc.topic.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.topic.dao.TopicMapper;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/4/14.
 */
@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {
    @Autowired
    TopicMapper topicMapper;
    @Override
    public BaseDao<Topic> getDao() {
        return topicMapper;
    }
}
