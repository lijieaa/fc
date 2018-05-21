package com.jianpanmao.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:08
 */

public class ImageMsg extends Msg {

    private ImageMsgContent image;

    public ImageMsgContent getImage() {
        return image;
    }

    public void setImage(ImageMsgContent image) {
        this.image = image;
    }

    public ImageMsg(ImageMsgContent image){
        this.image = image;
    }
    public ImageMsg(){}
}
