package com.we.fc.base;

import com.we.fc.config.SpringUtils;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.user.entity.DingtalkUser;
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

    public String getAccessToken(HttpSession session){
        Integer intermediaryId = ((DingtalkUser) session.getAttribute("user")).getIntermediary().getId();
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        WxApiHandler wxApiHandler = SpringUtils.getBean("wxApiHandler", WxApiHandler.class);
        WxPublic wxPublic = wxPublicService.findByCompanyId(intermediaryId);
        String accessToken = null;
        try {
            accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    protected Intermediary getCompany(HttpSession session){
        return ((DingtalkUser) session.getAttribute("user")).getIntermediary();
    }

    public WxPublic getWxPublic(HttpSession session){
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        WxPublic wxPublic = wxPublicService.findByCompanyId(getCompany(session).getId());
        return wxPublic;
    }
}
