package com.jianpanmao.notice.dao;

import com.jianpanmao.notice.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mayn on 2018/6/10.
 */
@Mapper
public interface NoticeMapper {
    void add(Notice notice);
    List<Notice> select(Integer userId);
    void check(Integer noticeId);
    Integer selectCount(Integer userId);

    void allCheck(Integer userId);
    }

