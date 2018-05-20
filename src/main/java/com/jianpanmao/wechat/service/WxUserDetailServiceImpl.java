package com.jianpanmao.wechat.service;

import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.base.BaseServiceImpl;
import com.jianpanmao.wechat.dao.WxUserDetailDao;
import com.jianpanmao.wechat.entity.WxUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zdc
 * @since 2018-04-14 23:05
 */
@Service
@Transactional
public class WxUserDetailServiceImpl extends BaseServiceImpl<WxUserDetail> implements WxUserDetailService {

    @Autowired private WxUserDetailDao wxUserDetailDao;

    @Override
    public BaseDao<WxUserDetail> getDao() {
        return wxUserDetailDao;
    }

}
