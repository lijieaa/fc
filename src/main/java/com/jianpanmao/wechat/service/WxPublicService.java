package com.jianpanmao.wechat.service;


import com.jianpanmao.wechat.base.BaseService;
import com.jianpanmao.wechat.entity.WxPublic;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-13 21:45
 */
public interface WxPublicService extends BaseService<WxPublic> {

    List<WxPublic> findByCompanyId(Integer companyId);

    WxPublic findBySourceId(String sourceId);
}
