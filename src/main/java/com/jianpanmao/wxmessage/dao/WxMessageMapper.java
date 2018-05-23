package com.jianpanmao.wxmessage.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.wxmessage.dto.WxMessageDto;
import com.jianpanmao.wxmessage.entity.WxMessage;
import com.jianpanmao.wxmessage.entity.WxMessageExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMessageMapper extends BaseDao<WxMessage, WxMessageExample, WxMessageDto, Integer> {
}