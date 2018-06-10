package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.ConLabDto;
import com.jianpanmao.sys.entity.ConLab;
import com.jianpanmao.sys.entity.ConLabExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConLabMapper extends BaseDao<ConLab, ConLabExample, ConLabDto, Integer> {

    int deleteByLabId(Integer labId);
}