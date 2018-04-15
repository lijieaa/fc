package com.we.fc.topic.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mayn on 2018/4/14.
 */
@Controller
@RequestMapping(value = "topic")
public class TopicController extends BaseController<Topic>{

    @Autowired
    TopicService service;
    @Override
    public BaseService<Topic> getService() {
        return service;
    }

}
