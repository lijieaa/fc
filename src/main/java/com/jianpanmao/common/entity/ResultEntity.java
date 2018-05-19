package com.jianpanmao.common.entity;


import org.springframework.http.HttpStatus;

public class ResultEntity {

    private int status= HttpStatus.OK.value();

    public ResultEntity(int status, String msg, Object content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    private String msg;

    private Object content;
}
