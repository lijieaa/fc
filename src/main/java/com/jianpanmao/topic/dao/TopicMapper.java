package com.jianpanmao.topic.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.topic.dto.TopicDto;
import com.jianpanmao.topic.entity.Topic;
import com.jianpanmao.topic.entity.TopicExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicMapper extends BaseDao<Topic, TopicExample, TopicDto, Integer> {
    List<Topic> findByIntermediaryId(Integer id);
}