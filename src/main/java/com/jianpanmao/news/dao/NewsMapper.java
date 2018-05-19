package com.jianpanmao.news.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.news.dto.NewsDto;
import com.jianpanmao.news.entity.News;
import com.jianpanmao.news.entity.NewsExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper extends BaseDao<News, NewsExample, NewsDto, Integer> {
}