package com.jianpanmao.attach.dto;
import java.math.BigDecimal;
import java.util.Date;

public class AttachDto {


private String path ;

public String getPath() {
return path;
}

public void setPath(String path) {
this.path = path;
}
private String filename ;

public String getFilename() {
return filename;
}

public void setFilename(String filename) {
this.filename = filename;
}
private Long size ;

public Long getSize() {
return size;
}

public void setSize(Long size) {
this.size = size;
}
private Date createTime ;

public Date getCreateTime() {
return createTime;
}

public void setCreateTime(Date createTime) {
this.createTime = createTime;
}
private String od ;

public String getOd() {
return od;
}

public void setOd(String od) {
this.od = od;
}
private String mime ;

public String getMime() {
return mime;
}

public void setMime(String mime) {
this.mime = mime;
}
private Date updateTime ;

public Date getUpdateTime() {
return updateTime;
}

public void setUpdateTime(Date updateTime) {
this.updateTime = updateTime;
}
private Integer id ;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}
}