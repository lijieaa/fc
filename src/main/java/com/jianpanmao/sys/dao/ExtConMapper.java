package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.ExtConDto;
import com.jianpanmao.sys.entity.ExtCon;
import com.jianpanmao.sys.entity.ExtConExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExtConMapper extends BaseDao<ExtCon, ExtConExample, ExtConDto, Integer> {
}