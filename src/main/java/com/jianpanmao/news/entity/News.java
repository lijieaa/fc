package com.jianpanmao.news.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class News implements Serializable {
    //
    private Integer tId;

    //
    @NotNull(message = "title不能为空！")
    private String title;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}