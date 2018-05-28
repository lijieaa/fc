package com.jianpanmao.wechat.dto;

/**
 * @author zdc
 * @since 2018-05-28 22:50
 */

public class VideoDTO {

    private String title;

    private String description;

    private String down_url;

    public VideoDTO(){}

    public VideoDTO(String title, String description, String down_url) {
        this.title = title;
        this.description = description;
        this.down_url = down_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }
}
