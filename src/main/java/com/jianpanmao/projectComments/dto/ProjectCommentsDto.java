package com.jianpanmao.projectComments.dto;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectCommentsDto {


private String projectCommentsNickname ;

public String getProjectCommentsNickname() {
return projectCommentsNickname;
}

public void setProjectCommentsNickname(String projectCommentsNickname) {
this.projectCommentsNickname = projectCommentsNickname;
}
private Byte projectCommentsType ;

public Byte getProjectCommentsType() {
return projectCommentsType;
}

public void setProjectCommentsType(Byte projectCommentsType) {
this.projectCommentsType = projectCommentsType;
}
private Integer projectCommentsParent ;

public Integer getProjectCommentsParent() {
return projectCommentsParent;
}

public void setProjectCommentsParent(Integer projectCommentsParent) {
this.projectCommentsParent = projectCommentsParent;
}
private String od ;

public String getOd() {
return od;
}

public void setOd(String od) {
this.od = od;
}
private Integer projectCommentsId ;

public Integer getProjectCommentsId() {
return projectCommentsId;
}

public void setProjectCommentsId(Integer projectCommentsId) {
this.projectCommentsId = projectCommentsId;
}
private Date projectCommentsUpdateTime ;

public Date getProjectCommentsUpdateTime() {
return projectCommentsUpdateTime;
}

public void setProjectCommentsUpdateTime(Date projectCommentsUpdateTime) {
this.projectCommentsUpdateTime = projectCommentsUpdateTime;
}
private Byte projectCommentsStatus ;

public Byte getProjectCommentsStatus() {
return projectCommentsStatus;
}

public void setProjectCommentsStatus(Byte projectCommentsStatus) {
this.projectCommentsStatus = projectCommentsStatus;
}
private String projectCommentsContent ;

public String getProjectCommentsContent() {
return projectCommentsContent;
}

public void setProjectCommentsContent(String projectCommentsContent) {
this.projectCommentsContent = projectCommentsContent;
}
private Integer projectId ;

public Integer getProjectId() {
return projectId;
}

public void setProjectId(Integer projectId) {
this.projectId = projectId;
}
private Date projectCommentsCreateTime ;

public Date getProjectCommentsCreateTime() {
return projectCommentsCreateTime;
}

public void setProjectCommentsCreateTime(Date projectCommentsCreateTime) {
this.projectCommentsCreateTime = projectCommentsCreateTime;
}
}