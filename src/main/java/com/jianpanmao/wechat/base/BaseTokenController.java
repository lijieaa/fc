package com.jianpanmao.wechat.base;

import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.SpringUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import com.jianpanmao.wechat.service.WxPublicServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-26 22:05
 */

public class BaseTokenController {

    // 检查公众号ID是否合法,false抛出异常，true返回wxPublic
    public WxPublic checkParam(HttpSession session, Integer wxPublicId) throws Exception{
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        WxPublic in = wxPublicService.selectByPrimaryKey(wxPublicId);
        if(in == null) throw  new Exception("参数异常");
        WxPublic result = null;
        List<WxPublic> wxPublics = getWxPublics(session);
        for(WxPublic wxPublic : wxPublics){
            if(wxPublic.getId().equals(wxPublicId)){
                result = wxPublic;
            }
        }
        if(result == null)
            throw new Exception("参数异常");
        else
            return result;
    }

    public String getAccessToken(HttpSession session, Integer wxPublicId) throws Exception{
        WxApiHandler wxApiHandler = SpringUtils.getBean("wxApiHandler", WxApiHandler.class);
        WxPublic wxPublic = checkParam(session, wxPublicId);
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

    public List<WxPublic> getWxPublics(HttpSession session){
        WxPublicService wxPublicService = SpringUtils.getBean("wxPublicServiceImpl", WxPublicServiceImpl.class);
        List<WxPublic> wxPublics = wxPublicService.findByCompanyId(getCompany(session).getIntermediaryId());
        return wxPublics;
    }
}
