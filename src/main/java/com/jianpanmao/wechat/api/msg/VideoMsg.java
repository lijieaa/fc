package com.jianpanmao.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:14
 */

public class VideoMsg extends Msg {

    private VideoMsgContent video;

    public VideoMsgContent getVideo() {
        return video;
    }

    public void setVideo(VideoMsgContent video) {
        this.video = video;
    }

    public VideoMsg(VideoMsgContent video){
        this.video = video;
    }
}
