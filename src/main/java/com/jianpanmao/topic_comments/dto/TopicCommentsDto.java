package com.jianpanmao.topic_comments.dto;
import java.math.BigDecimal;
import java.util.Date;

public class TopicCommentsDto {


private Date topicCommentsUpdateTime ;

public Date getTopicCommentsUpdateTime() {
return topicCommentsUpdateTime;
}

public void setTopicCommentsUpdateTime(Date topicCommentsUpdateTime) {
this.topicCommentsUpdateTime = topicCommentsUpdateTime;
}
private Integer topicId ;

public Integer getTopicId() {
return topicId;
}

public void setTopicId(Integer topicId) {
this.topicId = topicId;
}
private String topicCommentsContent ;

public String getTopicCommentsContent() {
return topicCommentsContent;
}

public void setTopicCommentsContent(String topicCommentsContent) {
this.topicCommentsContent = topicCommentsContent;
}
private Date topicCommentsCreateTime ;

public Date getTopicCommentsCreateTime() {
return topicCommentsCreateTime;
}

public void setTopicCommentsCreateTime(Date topicCommentsCreateTime) {
this.topicCommentsCreateTime = topicCommentsCreateTime;
}
private String od ;

public String getOd() {
return od;
}

public void setOd(String od) {
this.od = od;
}
private Integer userId ;

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
private Integer topicCommentsId ;

public Integer getTopicCommentsId() {
return topicCommentsId;
}

public void setTopicCommentsId(Integer topicCommentsId) {
this.topicCommentsId = topicCommentsId;
}
}