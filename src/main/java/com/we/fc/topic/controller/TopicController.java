package com.we.fc.topic.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.topic.dao.TopicMapper;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topic.service.TopicService;
import com.we.fc.topicComments.dao.TopicCommentsMapper;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mayn on 2018/4/14.
 */
@Controller
@RequestMapping(value = "topic")
public class TopicController extends BaseController<Topic>{

    @Autowired
    TopicMapper dao;

    @Autowired
    TopicCommentsMapper topicCommentsMapper;

    @Autowired
    TopicService service;
    @Override
    public BaseService<Topic> getService() {
        return service;
    }

    @GetMapping("intermediaryId/{id}")
    @ResponseBody
    public ResponseEntity findByIntermediaryId(@PathVariable("id")Integer id){
        ResponseEntity responseEntity = new ResponseEntity();
        List<Topic> topics =dao.findByIntermediaryId(id);
        for (Topic t:topics){
            Integer count = topicCommentsMapper.findCommentsCount(t.getId());
            t.setCommentsCount(count);
        }
        responseEntity.setData(topics);
        return responseEntity;
    }
}
