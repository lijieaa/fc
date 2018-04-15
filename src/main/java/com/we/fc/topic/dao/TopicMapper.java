package com.we.fc.topic.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.topic.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicMapper extends BaseDao<Topic>{

    List<Topic> findByIntermediaryId(Integer id);
}