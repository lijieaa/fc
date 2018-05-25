package com.jianpanmao.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:16
 */

public class ImageTextMsg extends Msg {

    private ImageTextMsgContent news;

    public ImageTextMsgContent getNews() {
        return news;
    }

    public void setNews(ImageTextMsgContent news) {
        this.news = news;
    }

    public ImageTextMsg(ImageTextMsgContent news){
        this.news = news;
    }

}
