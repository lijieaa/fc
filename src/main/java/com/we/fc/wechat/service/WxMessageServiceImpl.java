package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.api.msg.Msg;
import com.we.fc.wechat.dao.WxMessageDao;
import com.we.fc.wechat.dao.WxPublicDao;
import com.we.fc.wechat.dao.WxUserDetailDao;
import com.we.fc.wechat.dao.WxUserOpenIdDao;
import com.we.fc.wechat.entity.WxMessage;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.entity.WxUserDetail;
import com.we.fc.wechat.entity.WxUserOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 17:44
 */
@Service
@Transactional
public class WxMessageServiceImpl extends BaseServiceImpl<WxMessage> implements WxMessageService {

    @Autowired private WxMessageDao wxMessageDao;

    @Autowired private WxUserOpenIdDao wxUserOpenIdDao;

    @Autowired private WxUserDetailDao wxUserDetailDao;

    @Autowired private WxPublicDao wxPublicDao;

    @Autowired private WxApiHandler wxApiHandler;

    @Override
    public BaseDao<WxMessage> getDao() {
        return wxMessageDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WxMessage> findBySourceIdAndOpenId(String sourceId, String openId) {
        return wxMessageDao.findBySourceIdAndOpenId(sourceId, openId);
    }

    @Override
    public void subscribe(String sourceId, String openId) throws Exception {
        WxPublic wxPublic = wxPublicDao.findBySourceId(sourceId);
        String accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        WxUserDetail wxUserDetail = wxApiHandler.loadUserDetail(accessToken, openId);
        wxUserOpenIdDao.insert(new WxUserOpenId(openId, wxPublic));
        wxUserDetail.setWxPublic(wxPublic);
        wxUserDetail.setIntermediary(wxPublic.getIntermediary());
        wxUserDetailDao.insert(wxUserDetail);
    }

    @Override
    public void unSubscribe(String sourceId, String openId) throws Exception {
        wxMessageDao.deleteByFromUserAndToUser(openId, sourceId);
        wxUserDetailDao.deleteByOpenIdAndSourceId(openId, sourceId);
        wxUserOpenIdDao.deleteByOpenIdAndSourceId(openId, sourceId);
    }

    @Override
    public void sendMsg2user(String accessToken, Msg msg, WxMessage wxMessage) throws Exception {
        wxApiHandler.sendMsg2user(accessToken, msg);
        wxMessage.setCreateTime(new Date().getTime());
        wxMessageDao.insert(wxMessage);
    }
}
