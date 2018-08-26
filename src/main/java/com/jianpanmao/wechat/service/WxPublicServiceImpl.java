package com.jianpanmao.wechat.service;

import com.jianpanmao.exception.AccessTokenException;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import com.jianpanmao.wechat.api.response.OpenIdResponse;
import com.jianpanmao.wechat.base.BaseDao;
import com.jianpanmao.wechat.base.BaseServiceImpl;
import com.jianpanmao.wechat.dao.WxMaterialDao;
import com.jianpanmao.wechat.dao.WxPublicDao;
import com.jianpanmao.wechat.dao.WxUserDetailDao;
import com.jianpanmao.wechat.dao.WxUserOpenIdDao;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.entity.WxUserDetail;
import com.jianpanmao.wechat.entity.WxUserOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-13 21:46
 */
@Service
@Transactional
public class WxPublicServiceImpl extends BaseServiceImpl<WxPublic> implements WxPublicService {

    @Autowired private WxPublicDao wxPublicDao;

    @Autowired private WxApiHandler wxApiHandler;

    @Autowired private WxUserOpenIdDao wxUserOpenIdDao;

    @Autowired private WxUserDetailDao wxUserDetailDao;

    @Autowired private WxMaterialDao wxMaterialDao;

    @Override
    public BaseDao<WxPublic> getDao() {
        return wxPublicDao;
    }

    @Override
    public int insert(WxPublic wxPublic) throws Exception {

        // 验证是否能正确获取access_token
        String accessToken = null;
        int insert;
        try {
            accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
            insert = super.insert(wxPublic);
            //查询公从号的订阅用户的OPENID
            OpenIdResponse response = wxApiHandler.loadUserOpenId(accessToken);
            List<WxUserOpenId> list = new ArrayList<>();
            List<String> openIds = response.getData().getOpenid();
            for(String openId : openIds){
                list.add(new WxUserOpenId(openId, wxPublic));
                WxUserDetail wxUserDetail = wxApiHandler.loadUserDetail(accessToken, openId);
                wxUserDetail.setWxPublic(wxPublic);
                wxUserDetail.setIntermediary(wxPublic.getIntermediary());
                wxUserDetailDao.insert(wxUserDetail);
            }
            wxUserOpenIdDao.batchInsert(list);
        } catch (AccessTokenException e) {
            throw e;
        }

        return insert;
    }

    @Override
    public void deleteByPrimaryKey(Integer id) throws Exception {

        //删除有关素材
        wxMaterialDao.deleteByPublicId(id);

        //删除用户
        wxUserDetailDao.deleteByPublicId(id);

        // 删除中间表wx_user_openid的数据，这个中间表具体是做什么的还不清楚
        wxUserDetailDao.deleteWxUserOpenid(id);


        super.deleteByPrimaryKey(id);
    }

    @Override
    public List<WxPublic> findByCompanyId(Integer companyId) {
        return wxPublicDao.findByCompanyId(companyId);
    }

    @Override
    public WxPublic findBySourceId(String sourceId) {
        return wxPublicDao.findBySourceId(sourceId);
    }

}
