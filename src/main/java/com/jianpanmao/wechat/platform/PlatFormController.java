package com.jianpanmao.wechat.platform;

import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.utils.XmlUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import com.jianpanmao.wechat.entity.WxMessage;
import com.jianpanmao.wechat.entity.WxMessageType;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxMessageService;
import com.jianpanmao.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zdc
 * @since 2018-04-07 00:36
 */
@Controller
@RequestMapping("wx")
public class PlatFormController {

    @Autowired private WxMessageService wxMessageService;

    @Autowired private WxApiHandler wxApiHandler;

    @Autowired private WxPublicService wxPublicService;

    @GetMapping
    @ResponseBody
    @NoResultEntity
    public String valid(Token token){
        if(TokenUtils.checkSignature(token))
            return token.getEchostr();
        else
            return "";
    }

    @PostMapping
    @ResponseBody
    @NoResultEntity
    public String recevieMsg(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String c = null;
        StringBuilder sb = new StringBuilder();
        while((c = bufferedReader.readLine()) != null){
            sb.append(c);
        }
        try {
            WxMessage wxMessage = XmlUtils.fromXmlString(sb.toString());
            String msgType = wxMessage.getMsgType();
            if(msgType.equalsIgnoreCase(WxMessageType.EVENT)){
                String event = wxMessage.getEvent();
                if(event.equalsIgnoreCase(WxMessageType.EVENT_SUBSCRIBE)){
                    wxMessageService.subscribe(wxMessage.getToUserName(), wxMessage.getFromUserName());
                }else if (event.equalsIgnoreCase(WxMessageType.EVENT_UNSUBSCRIBE)){
                    wxMessageService.unSubscribe(wxMessage.getToUserName(), wxMessage.getFromUserName());
                    System.out.println(wxMessage.getFromUserName() + "取消订阅->" + wxMessage.getToUserName());
                }else if(event.equalsIgnoreCase(WxMessageType.EVENT_VIEW)){

                }else if(event.equalsIgnoreCase(WxMessageType.EVENT_CLICK)){

                }
            }else{
                // 将微信消息时间转换成标准时间
                wxMessage.setCreateTime(wxMessage.getCreateTime() * 1000L);
                // 如果是图片、语音、视频，保存到本地服务器
                if(msgType.equalsIgnoreCase(WxMessageType.IMAGE)
                        || msgType.equalsIgnoreCase(WxMessageType.VOICE)
                        || msgType.equalsIgnoreCase(WxMessageType.VIDEO)){
                    WxPublic wxPublic = wxPublicService.findBySourceId(wxMessage.getToUserName());
                    String accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
                    String filename = wxApiHandler.downloadTempMaterial(wxMessage.getMediaId(), accessToken,msgType);
                    wxMessage.setLocalFile(filename);
                }
                wxMessageService.insert(wxMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("微信消息接收异常："+e.getMessage());
        } finally {
            bufferedReader.close();
        }
        return "success";
    }

}
