package com.jianpanmao.wx.api.msg;

/**
 * @author zdc
 * @since 2018-04-29 16:44
 */

public class ImageText2MsgContent {

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public ImageText2MsgContent(String media_id) {
        this.media_id = media_id;
    }

    public ImageText2MsgContent(){}
}
