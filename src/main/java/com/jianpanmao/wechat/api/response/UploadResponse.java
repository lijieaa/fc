package com.jianpanmao.wechat.api.response;

/**
 * @author zdc
 * @since 2018-05-02 22:31
 */

public class UploadResponse {

    private String media_id;

    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
