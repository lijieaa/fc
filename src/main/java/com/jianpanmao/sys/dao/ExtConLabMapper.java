package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.ExtConLabDto;
import com.jianpanmao.sys.entity.ExtConLab;
import com.jianpanmao.sys.entity.ExtConLabExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExtConLabMapper extends BaseDao<ExtConLab, ExtConLabExample, ExtConLabDto, Integer> {

    int deleteByGroupId(Integer gid);

    List<ExtConLab> selectByGroupId(Integer gid);


    List<ExtConLab> selectByConId(Integer conId);
}