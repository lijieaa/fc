package com.jianpanmao.wxmessage.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class WxMessage implements Serializable {
    //
    private Integer messageId;

    //发送者open_id
    @NotNull(message = "fromUser不能为空！")
    private String fromUser;

    //接收者微信号
    @NotNull(message = "toUser不能为空！")
    private String toUser;

    //消息发送时间（整型）
    @NotNull(message = "createTime不能为空！")
    private Long createTime;

    //消息类型
    @NotNull(message = "msgType不能为空！")
    private String msgType;

    //消息内容(文本)
    private String content;

    //图片地址
    private String picUrl;

    //消息媒体ID
    private String mediaId;

    //语音格式(amr,speex等)
    private String format;

    //视频缩略图媒体ID
    private String thumbmediaId;

    //地理位置X
    private String locationX;

    //地理位置Y
    private String locationY;

    //地图缩放大小
    private Integer scale;

    //地理位置信息
    private String label;

    //消息标题
    private String title;

    //消息描述
    private String description;

    //消息链接
    private String url;

    //消息ID
    private Long msgId;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public String getThumbmediaId() {
        return thumbmediaId;
    }

    public void setThumbmediaId(String thumbmediaId) {
        this.thumbmediaId = thumbmediaId == null ? null : thumbmediaId.trim();
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX == null ? null : locationX.trim();
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY == null ? null : locationY.trim();
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", fromUser=").append(fromUser);
        sb.append(", toUser=").append(toUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", msgType=").append(msgType);
        sb.append(", content=").append(content);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", mediaId=").append(mediaId);
        sb.append(", format=").append(format);
        sb.append(", thumbmediaId=").append(thumbmediaId);
        sb.append(", locationX=").append(locationX);
        sb.append(", locationY=").append(locationY);
        sb.append(", scale=").append(scale);
        sb.append(", label=").append(label);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", url=").append(url);
        sb.append(", msgId=").append(msgId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}