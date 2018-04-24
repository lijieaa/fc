package com.we.fc.unit;

import java.util.List;

/**
 * Created by mayn on 2018/4/11.
 * 返回数据
 */
public class ResponseEntity {
    private String status = "200";
    private String messages = "操作成功！";
    private List list;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
