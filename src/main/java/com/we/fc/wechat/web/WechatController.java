package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-05 21:46
 */

@Controller
@RequestMapping("wechat")
public class WechatController extends BaseController {
    @Override
    public BaseService getService() {
        return null;
    }

    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "wechat/index";
    }

    @PostMapping("createMenu")
    @ResponseBody
    public String createMenu(){
        final String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=8_1oAGMGf_144ig1uOE5K_7JvdVmXT4kOFssXxDHgLT5ovwGHNWkD8BIivI2HGomQJoiswmaBMb60VMsMYxeAcC6WREJRO9py9Lia-xIVoPatYZE5t-dmaiqUkG-iSOSQAchAuubhvKobTDgygTZYjAGACIH";
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        return "ok";
    }
}
