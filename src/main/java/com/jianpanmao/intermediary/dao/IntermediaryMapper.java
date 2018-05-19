package com.jianpanmao.intermediary.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.intermediary.dto.IntermediaryDto;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.intermediary.entity.IntermediaryExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IntermediaryMapper extends BaseDao<Intermediary, IntermediaryExample, IntermediaryDto, Integer> {
}