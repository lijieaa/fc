package com.we.fc.wechat.api.response;

/**
 * @author zdc
 * @since 2018-04-13 22:43
 */

public class ResponseStatus {

    public static boolean isInvokeSuccess(String result){

        if(result.indexOf("errcode") == -1)
            return true;
        else
            return false;
    }
}
