package com.we.fc.topic.entity;

import com.we.fc.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class Topic extends BaseEntity implements Serializable {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.intermediary_id
     *
     * @mbggenerated
     */
    private Integer intermediaryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.topic_content
     *
     * @mbggenerated
     */
    private String topicContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table topic
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.user_id
     *
     * @return the value of topic.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.user_id
     *
     * @param userId the value for topic.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.intermediary_id
     *
     * @return the value of topic.intermediary_id
     *
     * @mbggenerated
     */
    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.intermediary_id
     *
     * @param intermediaryId the value for topic.intermediary_id
     *
     * @mbggenerated
     */
    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.topic_content
     *
     * @return the value of topic.topic_content
     *
     * @mbggenerated
     */
    public String getTopicContent() {
        return topicContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.topic_content
     *
     * @param topicContent the value for topic.topic_content
     *
     * @mbggenerated
     */
    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", topicContent=").append(topicContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}