package com.we.fc.wechat.service;

import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxMessage;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 17:43
 */
public interface WxMessageService extends BaseService<WxMessage> {

    /**
     * 查询指定公众号某订阅者的消息列表
     * @param sourceId 公从号sourceId
     * @param openId 订阅者openId
     * @return
     */
    List<WxMessage> findBySourceIdAndOpenId(String sourceId, String openId);

    /**
     * 用户订阅操作
     * @param sourceId 公从号sourceId
     * @param openId 订阅者openId
     * @throws Exception
     */
    void subscribe(String sourceId, String openId) throws Exception;

    /**
     * 用户取消订阅
     * @param sourceId 公从号sourceId
     * @param openId 订阅者openId
     * @throws Exception
     */
    void unSubscribe(String sourceId, String openId) throws Exception;
}
