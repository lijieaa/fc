package com.we.fc.wechat.api;

import com.we.fc.exception.AccessTokenException;
import com.we.fc.http.RequestTools;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.response.OpenIdResponse;
import com.we.fc.wechat.api.response.ResponseStatus;
import com.we.fc.wechat.entity.WxUserDetail;
import org.springframework.stereotype.Component;

/**
 * @author zdc
 * @since 2018-04-14 11:59
 */
@Component
public class WxApiHandler {


    // 查询公从号订阅者的OPENID列表
    public OpenIdResponse loadUserOpenId(String accessToken) throws Exception {

        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken;
        String result = RequestTools.processHttpRequest(url, "get", null);
        if(ResponseStatus.isInvokeSuccess(result)){
            return GsonUtils.toBean(result, OpenIdResponse.class);
        }else{
            throw new AccessTokenException("accessToken错误！");
        }

    }

    // 查询公从号用户的详细信息
    public WxUserDetail loadUserDetail(String accessToken, String openId)throws Exception{

        String url = "https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN&access_token="+accessToken+"&openid="+openId;
        String result = RequestTools.processHttpRequest(url, "get", null);
        if(ResponseStatus.isInvokeSuccess(result)){
            return GsonUtils.toBean(result, WxUserDetail.class);
        }else{
            throw new AccessTokenException("accessToken或openid错误");
        }
    }

}
