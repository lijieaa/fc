package com.we.fc.wechat.platform;

import com.we.fc.utils.XmlUtils;
import com.we.fc.wechat.entity.WxMessage;
import com.we.fc.wechat.entity.WxMessageType;
import com.we.fc.wechat.service.WxMessageService;
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

    @GetMapping
    @ResponseBody
    public String valid(Token token){
        if(TokenUtils.checkSignature(token))
            return token.getEchostr();
        else
            return "";
    }

    @PostMapping
    @ResponseBody
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
            String msgType = (wxMessage.getMsgType());
            if(msgType.equalsIgnoreCase(WxMessageType.EVENT)){
                String event = wxMessage.getEvent();
                if(event.equalsIgnoreCase(WxMessageType.EVENT_SUBSCRIBE)){
                    wxMessageService.subscribe(wxMessage.getToUserName(), wxMessage.getFromUserName());
                }else if (event.equalsIgnoreCase(WxMessageType.EVENT_UNSUBSCRIBE)){
                    wxMessageService.unSubscribe(wxMessage.getToUserName(), wxMessage.getFromUserName());
                    System.out.println(wxMessage.getFromUserName() + "取消订阅->" + wxMessage.getToUserName());
                }
            }else{
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
