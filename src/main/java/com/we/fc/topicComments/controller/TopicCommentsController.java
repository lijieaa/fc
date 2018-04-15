package com.we.fc.topicComments.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topicComments.dao.TopicCommentsMapper;
import com.we.fc.topicComments.entity.TopicComments;
import com.we.fc.topicComments.service.TopicCommentsService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mayn on 2018/4/15.
 */
@Controller
@RequestMapping("topicComments")
public class TopicCommentsController extends BaseController<TopicComments>{

    @Autowired
    TopicCommentsMapper dao;

    @Autowired
    TopicCommentsService service;
    @Override
    public BaseService<TopicComments> getService() {
        return service;
    }

    @GetMapping("topic/{id}")
    @ResponseBody
    public ResponseEntity findByTopicId(@PathVariable("id")Integer id){
        ResponseEntity responseEntity = new ResponseEntity();
        List<TopicComments> topicCommentses =dao.findByTopicId(id);
        responseEntity.setData(topicCommentses);
        return responseEntity;
    }
}
