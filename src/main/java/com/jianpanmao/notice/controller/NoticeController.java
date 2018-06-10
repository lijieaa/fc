package com.jianpanmao.notice.controller;

import com.jianpanmao.notice.dao.NoticeMapper;
import com.jianpanmao.notice.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mayn on 2018/6/10.
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    NoticeMapper noticeMapper;

    @GetMapping("select")
    public List<Notice> select(Integer userId) {
        return noticeMapper.select(userId);
    }

    @PutMapping("check")
    public void check(Integer noticeId) {
        noticeMapper.check(noticeId);
    }
}
