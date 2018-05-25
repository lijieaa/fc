package com.jianpanmao.wechat.api.response;

/**
 * @author zdc
 * @since 2018-04-13 22:43
 */

public class ResponseStatus {

    public static boolean isInvokeSuccess(String result){

        if(result.indexOf("\"errcode\":0") != -1 || result.indexOf("errcode") == -1)
            return true;
        else
            return false;
    }

    public static boolean sendMsgStatus(String result){
        if(result.indexOf("\"errcode\":45015") != -1){
            return false;
        }else{
            return true;
        }
    }
}
