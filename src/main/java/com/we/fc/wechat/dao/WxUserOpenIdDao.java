package com.we.fc.wechat.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.wechat.entity.WxUserOpenId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-14 12:14
 */
@Mapper
public interface WxUserOpenIdDao extends BaseDao<WxUserOpenId> {

    void batchInsert(List<WxUserOpenId> list) throws Exception;

    /**
     * 按订阅者openId和公从号sourceId删除
     * @param openId
     * @param sourceId
     * @throws Exception
     */
    void deleteByOpenIdAndSourceId(@Param("openId") String openId,
                                   @Param("sourceId")String sourceId) throws Exception;
}
