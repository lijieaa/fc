package com.we.fc.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:05
 */

public class Msg {

    private String touser;

    private String msgtype;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Msg(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }

    public Msg() {
    }
}
