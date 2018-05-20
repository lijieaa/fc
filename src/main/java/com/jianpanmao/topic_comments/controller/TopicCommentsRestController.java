package com.jianpanmao.topic_comments.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.topic_comments.dao.TopicCommentsMapper;
import com.jianpanmao.topic_comments.dto.TopicCommentsDto;
import com.jianpanmao.topic_comments.entity.TopicComments;
import com.jianpanmao.topic_comments.service.TopicCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/topiccomments")
public class TopicCommentsRestController {


    @Autowired
    TopicCommentsService topiccommentsService;

    @Autowired
    private TopicCommentsMapper dao;


    @PreAuthorize("hasAuthority('topiccomments:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody TopicComments entity) {
        return topiccommentsService.add(entity);
    }

    @PreAuthorize("hasAuthority('topiccomments:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return topiccommentsService.remove(id);
    }

    @PreAuthorize("hasAuthority('topiccomments:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return topiccommentsService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('topiccomments:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody TopicComments entity) {
        return topiccommentsService.update(entity);
    }

    @PreAuthorize("hasAuthority('topiccomments:view')")
    @RequestMapping(method = RequestMethod.GET)
    public TopicComments get(@RequestParam("id") Integer id) {
        return topiccommentsService.get(id);
    }

    @PreAuthorize("hasAuthority('topiccomments:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       TopicCommentsDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<TopicComments> list = topiccommentsService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<TopicComments> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
    @PreAuthorize("hasAuthority('topiccomments:view')")
    @GetMapping("topic/{id}")
    @ResponseBody
    public List<TopicComments> findByTopicId(@PathVariable("id") Integer id) {
        return dao.findByTopicId(id);
    }

}
