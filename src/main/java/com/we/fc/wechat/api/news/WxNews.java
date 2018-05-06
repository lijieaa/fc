package com.we.fc.wechat.api.news;

import java.util.List;

/**
 * @author zdc
 * @since 2018-05-05 17:10
 */

public class WxNews {

    private List<WxNewsContent> articles;

    public List<WxNewsContent> getArticles() {
        return articles;
    }

    public void setArticles(List<WxNewsContent> articles) {
        this.articles = articles;
    }
}
