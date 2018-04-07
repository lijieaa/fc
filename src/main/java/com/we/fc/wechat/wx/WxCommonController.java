package com.we.fc.wechat.wx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公众号页面
 * @author zdc
 * @since 2018-04-07 16:42
 */
@Controller
@RequestMapping("wx/common")
public class WxCommonController {

    @GetMapping("login")
    public String login(){
        return "wx/login";
    }

    @GetMapping("index")
    public String index(){
        return "wx/index";
    }

    @GetMapping("productlist")
    public String productlist(){
        return "wx/productlist";
    }

    @GetMapping("projectdetails")
    public String projectdetails(){
        return "wx/projectdetails";
    }

    @GetMapping("projectlist")
    public String projectlist(){
        return "wx/projectlist";
    }

    @GetMapping("productdetails")
    public String productdetails(){
        return "wx/productdetails";
    }
}
