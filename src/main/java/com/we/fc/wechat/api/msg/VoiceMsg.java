package com.we.fc.wechat.api.msg;

/**
 * @author zdc
 * @since 2018-04-24 22:13
 */

public class VoiceMsg extends Msg {

    private VoiceMsgContent voice;

    public VoiceMsgContent getVoice() {
        return voice;
    }

    public void setVoice(VoiceMsgContent voice) {
        this.voice = voice;
    }

    public VoiceMsg(){}

    public VoiceMsg(VoiceMsgContent voice){
        this.voice = voice;
    }
}
