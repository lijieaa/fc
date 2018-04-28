package com.we.fc.base;

import com.we.fc.company.entity.Company;
import com.we.fc.config.SpringUtils;
import com.we.fc.user.entity.User;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.service.WxPublicService;
import com.we.fc.wechat.service.WxPublicServiceImpl;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-26 22:05
 */

public class BaseTokenController {

    protected String getAccessToken(HttpSession session){
        Integer companyId = ((User) session.getAttribute("user")).getCompany().getId();
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        WxApiHandler wxApiHandler = SpringUtils.getBean("wxApiHandler", WxApiHandler.class);
        WxPublic wxPublic = wxPublicService.findByCompanyId(companyId);
        String accessToken = null;
        try {
            accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    protected Company getCompany(HttpSession session){
        return ((User) session.getAttribute("user")).getCompany();
    }

    protected WxPublic getWxPublic(HttpSession session){
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        WxPublic wxPublic = wxPublicService.findByCompanyId(getCompany(session).getId());
        return wxPublic;
    }
}
