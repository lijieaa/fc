package com.jianpanmao.topic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.topic.dao.TopicMapper;
import com.jianpanmao.topic.dto.TopicDto;
import com.jianpanmao.topic.entity.Topic;
import com.jianpanmao.topic.service.TopicService;
import com.jianpanmao.topic_comments.dao.TopicCommentsMapper;
import com.jianpanmao.topic_comments.entity.TopicComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicRestController {


    @Autowired
    TopicService topicService;

    @Autowired
    private TopicMapper dao;

    @Autowired
    private TopicCommentsMapper topicCommentsMapper;


    @PreAuthorize("hasAuthority('topic:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody Topic entity) {
        return topicService.add(entity);
    }

    @PreAuthorize("hasAuthority('topic:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return topicService.remove(id);
    }

    @PreAuthorize("hasAuthority('topic:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return topicService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('topic:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Topic entity) {
        return topicService.update(entity);
    }

    @PreAuthorize("hasAuthority('topic:view')")
    @RequestMapping(method = RequestMethod.GET)
    public Topic get(@RequestParam("id") Integer id) {
        return topicService.get(id);
    }

    @PreAuthorize("hasAuthority('topic:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       TopicDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Topic> list = topicService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Topic> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    @PreAuthorize("hasAuthority('topic:view')")
    @GetMapping("intermediaryId/{id}")
    @ResponseBody
    public List<Topic> findByIntermediaryId(@PathVariable("id") Integer id) {

        List<Topic> topics = dao.findByIntermediaryId(id);
        for (Topic topic:topics){
            Integer count = topicCommentsMapper.findCommentsCount(topic.getTopicId());
            topic.setCommentsCount(count);
        }
        return topics;
    }
}
