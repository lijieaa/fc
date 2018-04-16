package com.we.fc.wechat.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.wechat.entity.WxUserOpenId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-14 12:14
 */
@Mapper
public interface WxUserOpenIdDao extends BaseDao<WxUserOpenId> {

    void batchInsert(List<WxUserOpenId> list) throws Exception;
}
