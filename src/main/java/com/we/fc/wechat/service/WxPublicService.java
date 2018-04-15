package com.we.fc.wechat.service;

import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxPublic;

/**
 * @author zdc
 * @since 2018-04-13 21:45
 */
public interface WxPublicService extends BaseService<WxPublic> {

    WxPublic findByCompanyId(Integer companyId);
}
