package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.LabGroupDto;
import com.jianpanmao.sys.entity.LabGroup;
import com.jianpanmao.sys.entity.LabGroupExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabGroupMapper extends BaseDao<LabGroup, LabGroupExample, LabGroupDto, Integer> {
}