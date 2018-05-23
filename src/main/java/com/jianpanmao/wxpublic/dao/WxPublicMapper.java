package com.jianpanmao.wxpublic.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.wxpublic.dto.WxPublicDto;
import com.jianpanmao.wxpublic.entity.WxPublic;
import com.jianpanmao.wxpublic.entity.WxPublicExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WxPublicMapper extends BaseDao<WxPublic, WxPublicExample, WxPublicDto, Integer> {

    List<WxPublic> findByCompanyId(Integer companyId);

    WxPublic findBySourceId(String sourceId);
}