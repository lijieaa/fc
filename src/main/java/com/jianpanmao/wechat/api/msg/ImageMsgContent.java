package com.jianpanmao.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:08
 */

public class ImageMsgContent {

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public ImageMsgContent(String media_id) {
        this.media_id = media_id;
    }

    public ImageMsgContent() {
    }
}
