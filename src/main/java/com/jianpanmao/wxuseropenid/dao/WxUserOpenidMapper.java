package com.jianpanmao.wxuseropenid.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.wxuseropenid.dto.WxUserOpenidDto;
import com.jianpanmao.wxuseropenid.entity.WxUserOpenid;
import com.jianpanmao.wxuseropenid.entity.WxUserOpenidExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxUserOpenidMapper extends BaseDao<WxUserOpenid, WxUserOpenidExample, WxUserOpenidDto, Integer> {
}