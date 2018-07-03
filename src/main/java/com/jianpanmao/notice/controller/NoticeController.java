package com.jianpanmao.notice.controller;

import com.jianpanmao.notice.dao.NoticeMapper;
import com.jianpanmao.notice.dto.NoticeDto;
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
    public NoticeDto select(Integer userId) {
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setNotices(noticeMapper.select(userId));
        noticeDto.setCount(noticeMapper.selectCount(userId));
        return noticeDto;
    }

    @PutMapping("check")
    public void check(Integer noticeId) {
        noticeMapper.check(noticeId);
    }

    @PutMapping("allCheck")
    public void allCheck(Integer userId){
        noticeMapper.allCheck(userId);
    }
}
