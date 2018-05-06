package com.we.fc.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.we.fc.intermediary.entity.Intermediary;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zdc
 * @since 2018-03-27 21:53
 */

public class BaseEntity implements Serializable{

    private Integer id;

    private Intermediary intermediary;

    private Date createTime;

    private Date updateTime;

    private Integer wxPublicId;

    public Integer getWxPublicId() {
        return wxPublicId;
    }

    public void setWxPublicId(Integer wxPublicId) {
        this.wxPublicId = wxPublicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }
}
