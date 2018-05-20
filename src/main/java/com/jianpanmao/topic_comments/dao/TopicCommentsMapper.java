package com.jianpanmao.topic_comments.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.topic_comments.dto.TopicCommentsDto;
import com.jianpanmao.topic_comments.entity.TopicComments;
import com.jianpanmao.topic_comments.entity.TopicCommentsExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicCommentsMapper extends BaseDao<TopicComments, TopicCommentsExample, TopicCommentsDto, Integer> {

    List<TopicComments> findByTopicId(Integer topicId);
    Integer findCommentsCount(Integer topicId);
}