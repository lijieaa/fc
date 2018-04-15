package com.we.fc.topicComments.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.topicComments.entity.TopicComments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicCommentsMapper extends BaseDao<TopicComments>{
    List<TopicComments> findByTopicId(Integer topicId);
}