package com.jianpanmao.wechat.dao;

import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.entity.WxMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 17:42
 */
@Mapper
public interface WxMessageDao extends BaseDao<WxMessage> {

    /**
     * 查询指定公从号中，某个用户的消息
     * @param sourceId
     * @param openId
     * @return
     */
    List<WxMessage> findBySourceIdAndOpenId(@Param("sourceId") String sourceId,
                                            @Param("openId") String openId);

    /**
     * 按订阅者openId和公从号sourceId删除
     * @param fromUser
     * @param toUser
     * @throws Exception
     */
    void deleteByFromUserAndToUser(@Param("fromUser") String fromUser,
                                   @Param("toUser") String toUser) throws Exception;

    List<WxMessage> findByPublicId(Integer wxPublicId);
}
