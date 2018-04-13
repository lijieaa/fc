package com.we.fc.wechat.api;

import com.we.fc.exception.AccessTokenException;
import com.we.fc.http.RequestTools;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.response.AccessTokenResponse;
import com.we.fc.wechat.api.response.ResponseStatus;

/**
 * @author zdc
 * @since 2018-04-13 22:24
 */

public class AccessTokenHandler {

    public static String getAccessToken(String appId, String appSecret) throws AccessTokenException{
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=";
        url += appId;
        url += "&secret=";
        url += appSecret;
        String result = RequestTools.processHttpRequest(url, "get", null);
        if(ResponseStatus.isInvokeSuccess(result)){
            return GsonUtils.toBean(result, AccessTokenResponse.class).getAccess_token();
        }else{
            throw new AccessTokenException("appId或appSecret错误，无法获取accessToken");
        }
    }

}
