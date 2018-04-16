package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.exception.AccessTokenException;
import com.we.fc.wechat.api.AccessTokenHandler;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.api.response.OpenIdResponse;
import com.we.fc.wechat.dao.WxPublicDao;
import com.we.fc.wechat.dao.WxUserDetailDao;
import com.we.fc.wechat.dao.WxUserOpenIdDao;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.entity.WxUserDetail;
import com.we.fc.wechat.entity.WxUserOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zdc
 * @since 2018-04-13 21:46
 */
@Service
@Transactional
public class WxPublicServiceImpl extends BaseServiceImpl<WxPublic> implements WxPublicService {

    @Autowired private WxPublicDao wxPublicDao;

    @Autowired private StringRedisTemplate stringRedisTemplate;

    @Autowired private WxApiHandler wxApiHandler;

    @Autowired private WxUserOpenIdDao wxUserOpenIdDao;

    @Autowired private WxUserDetailDao wxUserDetailDao;

    @Override
    public BaseDao<WxPublic> getDao() {
        return wxPublicDao;
    }

    @Override
    public void insert(WxPublic wxPublic) throws Exception {

        // 验证是否能正确获取access_token
        String accessToken = null;
        try {
            accessToken = AccessTokenHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
            stringRedisTemplate
                    .opsForValue()
                    .set(wxPublic.getCompany().getId().toString(), accessToken,7200L, TimeUnit.SECONDS);
            super.insert(wxPublic);
            //查询公从号的订阅用户的OPENID
            OpenIdResponse response = wxApiHandler.loadUserOpenId(accessToken);
            List<WxUserOpenId> list = new ArrayList<>();
            List<String> openIds = response.getData().getOpenid();
            for(String openId : openIds){
                list.add(new WxUserOpenId(openId, wxPublic));
                WxUserDetail wxUserDetail = wxApiHandler.loadUserDetail(accessToken, openId);
                wxUserDetail.setWxPublic(wxPublic);
                wxUserDetail.setCompany(wxPublic.getCompany());
                wxUserDetailDao.insert(wxUserDetail);
            }
            wxUserOpenIdDao.batchInsert(list);
        } catch (AccessTokenException e) {
            throw e;
        }

    }

    @Override
    public WxPublic findByCompanyId(Integer companyId) {
        return wxPublicDao.findByCompanyId(companyId);
    }
}
