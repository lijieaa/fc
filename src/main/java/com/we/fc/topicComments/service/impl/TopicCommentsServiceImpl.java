package com.we.fc.topicComments.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.topicComments.dao.TopicCommentsMapper;
import com.we.fc.topicComments.entity.TopicComments;
import com.we.fc.topicComments.service.TopicCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/4/15.
 */
@Service
public class TopicCommentsServiceImpl extends BaseServiceImpl<TopicComments> implements TopicCommentsService {

    @Autowired
    TopicCommentsMapper dao;

    @Override
    public BaseDao<TopicComments> getDao() {
        return dao;
    }
}
