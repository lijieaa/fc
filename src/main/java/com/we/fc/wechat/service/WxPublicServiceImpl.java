package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.wechat.dao.WxPublicDao;
import com.we.fc.wechat.entity.WxPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zdc
 * @since 2018-04-12 22:08
 */
@Service
@Transactional
public class WxPublicServiceImpl extends BaseServiceImpl<WxPublic> implements WxPublicService {

    @Autowired private WxPublicDao wxPublicDao;

    @Override
    public BaseDao<WxPublic> getDao() {
        return wxPublicDao;
    }

}
