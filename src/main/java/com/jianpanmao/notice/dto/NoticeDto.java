package com.jianpanmao.notice.dto;

import com.jianpanmao.notice.entity.Notice;

import java.util.List;

/**
 * Created by mayn on 2018/6/14.
 */
public class NoticeDto {
    private List<Notice> notices;
    private Integer count;

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
