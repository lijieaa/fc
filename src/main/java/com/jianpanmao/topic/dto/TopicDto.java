package com.jianpanmao.topic.dto;
import java.math.BigDecimal;
import java.util.Date;

public class TopicDto {


private Date topicUpdateTime ;

public Date getTopicUpdateTime() {
return topicUpdateTime;
}

public void setTopicUpdateTime(Date topicUpdateTime) {
this.topicUpdateTime = topicUpdateTime;
}
private Integer topicStatus ;

public Integer getTopicStatus() {
return topicStatus;
}

public void setTopicStatus(Integer topicStatus) {
this.topicStatus = topicStatus;
}
private Integer topicId ;

public Integer getTopicId() {
return topicId;
}

public void setTopicId(Integer topicId) {
this.topicId = topicId;
}
private String topicContent ;

public String getTopicContent() {
return topicContent;
}

public void setTopicContent(String topicContent) {
this.topicContent = topicContent;
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
private Date topicCreateTime ;

public Date getTopicCreateTime() {
return topicCreateTime;
}

public void setTopicCreateTime(Date topicCreateTime) {
this.topicCreateTime = topicCreateTime;
}
private Integer intermediaryId ;

public Integer getIntermediaryId() {
return intermediaryId;
}

public void setIntermediaryId(Integer intermediaryId) {
this.intermediaryId = intermediaryId;
}
}