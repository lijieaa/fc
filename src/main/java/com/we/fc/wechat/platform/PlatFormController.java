package com.we.fc.wechat.platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zdc
 * @since 2018-04-07 00:36
 */
@Controller
@RequestMapping("wx")
public class PlatFormController {

    @GetMapping
    @ResponseBody
    public String valid(Token token){
        if(TokenUtils.checkSignature(token))
            return token.getEchostr();
        else
            return null;
    }

}
