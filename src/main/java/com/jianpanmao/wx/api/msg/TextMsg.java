package com.jianpanmao.wx.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:05
 */

public class TextMsg extends Msg {

    private TextMsgContent text;

    public TextMsgContent getText() {
        return text;
    }

    public void setText(TextMsgContent text) {
        this.text = text;
    }

    public TextMsg(TextMsgContent text){
        this.text = text;
    }
    public TextMsg(){}
}
