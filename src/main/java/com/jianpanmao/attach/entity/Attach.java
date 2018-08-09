package com.jianpanmao.attach.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Attach implements Serializable {
    //
    private Integer id;

    //
    @NotNull(message = "filename不能为空！")
    private String filename;

    //
    @NotNull(message = "path不能为空！")
    private String path;

    //
    private Long size;

    //
    @NotNull(message = "mime不能为空！")
    private String mime;

    //
    @NotNull(message = "createTime不能为空！")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;

    //
    @NotNull(message = "updateTime不能为空！")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime == null ? null : mime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filename=").append(filename);
        sb.append(", path=").append(path);
        sb.append(", size=").append(size);
        sb.append(", mime=").append(mime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}