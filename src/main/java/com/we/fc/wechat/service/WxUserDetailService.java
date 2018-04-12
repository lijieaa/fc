package com.we.fc.wechat.service;

import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxUserDetail;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-12 21:35
 */
public interface WxUserDetailService extends BaseService<WxUserDetail> {

    List<WxUserDetail> selectByCompanyId(Integer companyId);
}
