package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.wechat.dao.WxOpenIdDao;
import com.we.fc.wechat.dao.WxUserDetailDao;
import com.we.fc.wechat.entity.WxOpenId;
import com.we.fc.wechat.entity.WxUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-11 22:41
 */
@Service
@Transactional
public class WxUserDetailServiceImpl extends BaseServiceImpl<WxUserDetail> implements WxUserDetailService{

    @Autowired
    private WxUserDetailDao wxUserDetailDao;

    @Override
    public BaseDao<WxUserDetail> getDao() {
        return wxUserDetailDao;
    }


    @Override
    public List<WxUserDetail> selectByCompanyId(Integer companyId) {
        return wxUserDetailDao.selectByCompanyId(companyId);
    }
}
