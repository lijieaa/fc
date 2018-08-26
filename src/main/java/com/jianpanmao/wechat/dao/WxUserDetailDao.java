package com.jianpanmao.wechat.dao;

import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.entity.WxUserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zdc
 * @since 2018-04-14 16:50
 */
@Mapper
public interface WxUserDetailDao extends BaseDao<WxUserDetail> {

    /**
     * 按订阅者openId和公从号sourceId删除
     * @param openId
     * @param sourceId
     * @throws Exception
     */
    void deleteByOpenIdAndSourceId(@Param("openId") String openId,
                                   @Param("sourceId") String sourceId) throws Exception;

    /**
     * 删除公众号相关用户
     * @param publicId
     * @return
     */
    public int deleteByPublicId(Integer publicId);


    /**
     * 删除中间表wx_user_openid的数据，这个中间表具体是做什么的还不清楚
     * @param publicId
     * @return
     */
    public int deleteWxUserOpenid(Integer publicId);
}
