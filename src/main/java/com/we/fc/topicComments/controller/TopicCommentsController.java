package com.we.fc.topicComments.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.topic.entity.Topic;
import com.we.fc.topicComments.dao.TopicCommentsMapper;
import com.we.fc.topicComments.entity.TopicComments;
import com.we.fc.topicComments.service.TopicCommentsService;
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

    @Override
    protected ResponseEntity hookExist(TopicComments topicComments) {
        return null;
    }

    @GetMapping("topic/{id}")
    @ResponseBody
    public ResponseEntity findByTopicId(@PathVariable("id")Integer id){
        ResponseEntity responseEntity = new ResponseEntity();
        List<TopicComments> topicCommentses =dao.findByTopicId(id);
        responseEntity.setData(topicCommentses);
        return responseEntity;
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody TopicComments t, BindingResult result, HttpSession session) {
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
