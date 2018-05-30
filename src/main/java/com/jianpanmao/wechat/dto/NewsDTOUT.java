package com.jianpanmao.wechat.dto;

import java.util.List;

/**
 * @author zdc
 * @since 2018-05-29 20:28
 */

public class NewsDTOUT {

    private List<NewsDTO> news_item;

    public List<NewsDTO> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<NewsDTO> news_item) {
        this.news_item = news_item;
    }
}
