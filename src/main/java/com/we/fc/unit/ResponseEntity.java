package com.we.fc.unit;

import java.util.List;

/**
 * Created by mayn on 2018/4/11.
 */
public class ResponseEntity {
    private String status = "200";
    private String messages = "";
    private List data;

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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
