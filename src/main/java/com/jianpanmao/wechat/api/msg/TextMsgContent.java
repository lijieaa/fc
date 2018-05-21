package com.jianpanmao.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:07
 */

public class TextMsgContent {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextMsgContent(String content) {
        this.content = content;
    }
    public TextMsgContent(){
    }
}
