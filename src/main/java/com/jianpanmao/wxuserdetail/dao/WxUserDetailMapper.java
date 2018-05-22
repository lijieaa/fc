package com.jianpanmao.wxuserdetail.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.wxuserdetail.dto.WxUserDetailDto;
import com.jianpanmao.wxuserdetail.entity.WxUserDetail;
import com.jianpanmao.wxuserdetail.entity.WxUserDetailExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxUserDetailMapper extends BaseDao<WxUserDetail, WxUserDetailExample, WxUserDetailDto, Integer> {
}