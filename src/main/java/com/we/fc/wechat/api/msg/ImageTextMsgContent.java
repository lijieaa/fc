package com.we.fc.wechat.api.msg;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-24 22:16
 */

public class ImageTextMsgContent {

    private List<ImageTextMsgContentArticle> articles;

    public List<ImageTextMsgContentArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<ImageTextMsgContentArticle> articles) {
        this.articles = articles;
    }
}
