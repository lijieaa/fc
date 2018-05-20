package com.jianpanmao.topic_comments.entity;

import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class TopicComments implements Serializable {
    //
    private Integer topicCommentsId;

    //跟进ID
    @NotNull(message = "跟进id不能为空")
    private Integer topicId;

    //评论人
    private DingtalkUser user;

    //创建时间
    private Date topicCommentsCreateTime;

    //更新时间
    private Date topicCommentsUpdateTime;

    //评论内容
    @NotBlank(message = "评论内容不能为空")
    private String topicCommentsContent;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getTopicCommentsId() {
        return topicCommentsId;
    }

    public void setTopicCommentsId(Integer topicCommentsId) {
        this.topicCommentsId = topicCommentsId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    public Date getTopicCommentsCreateTime() {
        return topicCommentsCreateTime;
    }

    public void setTopicCommentsCreateTime(Date topicCommentsCreateTime) {
        this.topicCommentsCreateTime = topicCommentsCreateTime;
    }

    public Date getTopicCommentsUpdateTime() {
        return topicCommentsUpdateTime;
    }

    public void setTopicCommentsUpdateTime(Date topicCommentsUpdateTime) {
        this.topicCommentsUpdateTime = topicCommentsUpdateTime;
    }

    public String getTopicCommentsContent() {
        return topicCommentsContent;
    }

    public void setTopicCommentsContent(String topicCommentsContent) {
        this.topicCommentsContent = topicCommentsContent == null ? null : topicCommentsContent.trim();
    }

}