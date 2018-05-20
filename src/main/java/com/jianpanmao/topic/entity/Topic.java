package com.jianpanmao.topic.entity;

import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Topic implements Serializable {
    //
    private Integer topicId;

    //跟进人
    private DingtalkUser user;

    //中间商ID
    @NotNull(message = "中间商不能为空")
    private Intermediary intermediary;

    //创建时间
    private Date topicCreateTime;

    //更新时间
    private Date topicUpdateTime;

    //跟进状态：0已处理，1正在处理
    @NotNull(message = "跟进状态不能为空！")
    private Integer topicStatus;

    //跟进内容
    @NotNull(message = "跟进内容不能为空！")
    private String topicContent;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Date getTopicCreateTime() {
        return topicCreateTime;
    }

    public void setTopicCreateTime(Date topicCreateTime) {
        this.topicCreateTime = topicCreateTime;
    }

    public Date getTopicUpdateTime() {
        return topicUpdateTime;
    }

    public void setTopicUpdateTime(Date topicUpdateTime) {
        this.topicUpdateTime = topicUpdateTime;
    }

    public Integer getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(Integer topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

}