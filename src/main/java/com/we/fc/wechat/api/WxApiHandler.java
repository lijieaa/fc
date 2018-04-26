package com.we.fc.wechat.api;

import com.we.fc.exception.AccessTokenException;
import com.we.fc.http.RequestTools;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.msg.Msg;
import com.we.fc.wechat.api.response.AccessTokenResponse;
import com.we.fc.wechat.api.response.OpenIdResponse;
import com.we.fc.wechat.api.response.ResponseStatus;
import com.we.fc.wechat.api.response.SubmitResponse;
import com.we.fc.wechat.entity.WxUserDetail;
import org.springframework.stereotype.Component;

/**
 * @author zdc
 * @since 2018-04-14 11:59
 */
@Component
public class WxApiHandler {


    public String getAccessToken(String appId, String appSecret) throws Exception{

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

    // 查询公从号的订阅者OPENID列表
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

    // 向用户发送消息
    public SubmitResponse sendMsg2user(String accessToken, Msg msg) throws Exception{

        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        String result = RequestTools.processPostJson(url, GsonUtils.toJson(msg));
        if(ResponseStatus.isInvokeSuccess(result)){
            return GsonUtils.toBean(result, SubmitResponse.class);
        }else{
            throw new AccessTokenException("accessToken或openid错误");
        }

    }

}
