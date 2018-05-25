package com.jianpanmao.wechat.dao;

import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.entity.WxPublic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-13 21:47
 */
@Mapper
public interface WxPublicDao extends BaseDao<WxPublic> {

    List<WxPublic> findByCompanyId(Integer companyId);

    WxPublic findBySourceId(String sourceId);
}
