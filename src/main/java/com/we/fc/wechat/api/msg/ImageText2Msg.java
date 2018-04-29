package com.we.fc.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-29 16:43
 */

public class ImageText2Msg extends Msg {

    private ImageText2MsgContent mpnews;

    public ImageText2MsgContent getMpnews() {
        return mpnews;
    }

    public void setMpnews(ImageText2MsgContent mpnews) {
        this.mpnews = mpnews;
    }

    public ImageText2Msg(ImageText2MsgContent mpnews) {
        this.mpnews = mpnews;
    }

    public ImageText2Msg(){}
}
