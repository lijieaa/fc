package com.we.fc.topic.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.topic.dao.TopicMapper;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topic.service.TopicService;
import com.we.fc.topicComments.dao.TopicCommentsMapper;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody Topic t, BindingResult result, HttpSession session) {
        t.setUser(super.getSelf(session));
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.hasErrors()){
            responseEntity.setStatus("500");
            responseEntity.setMessages("验证失败");
            responseEntity.setData(result.getAllErrors());
            return responseEntity;
        }
        try {
            getService().insert(t);
            return responseEntity;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("已存在的实体");
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }
}
