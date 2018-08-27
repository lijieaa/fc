package com.jianpanmao.wechat.dao;

import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.entity.WxMaterial;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zdc
 * @since 2018-05-01 22:40
 */
@Mapper
public interface WxMaterialDao extends BaseDao<WxMaterial> {

    WxMaterial findByMediaId(String mediaId);

    int deleteByPublicId(Integer publicId);

}
