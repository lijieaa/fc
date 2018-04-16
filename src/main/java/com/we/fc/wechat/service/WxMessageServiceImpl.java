package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.wechat.dao.WxMessageDao;
import com.we.fc.wechat.entity.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 17:44
 */
@Service
@Transactional
public class WxMessageServiceImpl extends BaseServiceImpl<WxMessage> implements WxMessageService {

    @Autowired private WxMessageDao wxMessageDao;

    @Override
    public BaseDao<WxMessage> getDao() {
        return wxMessageDao;
    }

    @Override
    public List<WxMessage> findBySourceIdAndOpenId(String sourceId, String openId) {
        return wxMessageDao.findBySourceIdAndOpenId(sourceId, openId);
    }
}
