package com.jianpanmao.attach.dao;

import com.jianpanmao.attach.dto.AttachDto;
import com.jianpanmao.attach.entity.Attach;
import com.jianpanmao.attach.entity.AttachExample;
import com.jianpanmao.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachMapper extends BaseDao<Attach, AttachExample, AttachDto, Integer> {
}