package com.we.fc.topicComments.entity;

import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class TopicComments extends BaseEntity implements Serializable {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_comments.topic_id
     *
     * @mbggenerated
     */
    @NotNull(message = "跟进id不能为空")
    private Integer topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_comments.user_id
     *
     * @mbggenerated
     */
    private DingtalkUser user;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_comments.topic_comments_content
     *
     * @mbggenerated
     */
    @NotBlank(message = "评论内容不能为空")
    private String topicCommentsContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table topic_comments
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_comments.topic_id
     *
     * @return the value of topic_comments.topic_id
     *
     * @mbggenerated
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_comments.topic_id
     *
     * @param topicId the value for topic_comments.topic_id
     *
     * @mbggenerated
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_comments.topic_comments_content
     *
     * @return the value of topic_comments.topic_comments_content
     *
     * @mbggenerated
     */
    public String getTopicCommentsContent() {
        return topicCommentsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_comments.topic_comments_content
     *
     * @param topicCommentsContent the value for topic_comments.topic_comments_content
     *
     * @mbggenerated
     */
    public void setTopicCommentsContent(String topicCommentsContent) {
        this.topicCommentsContent = topicCommentsContent == null ? null : topicCommentsContent.trim();
    }

}