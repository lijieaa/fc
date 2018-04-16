package com.we.fc.wechat.service;

import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxMessage;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 17:43
 */
public interface WxMessageService extends BaseService<WxMessage> {

    List<WxMessage> findBySourceIdAndOpenId(String sourceId, String openId);
}
