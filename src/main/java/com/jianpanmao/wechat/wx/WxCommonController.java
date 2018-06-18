package com.jianpanmao.wechat.wx;

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

    @GetMapping("company")
    public String login(){
        return "wx/company";
    }

    @GetMapping("index")
    public String index(){
        return "wx/index";
    }

    @GetMapping("equipment")
    public String equipment(){
        return "wx/equipment";
    }

    @GetMapping("operate")
    public String operate(){
        return "wx/operate";
    }

    @GetMapping("project")
    public String project(){
        return "wx/project";
    }

    @GetMapping("projectinfo")
    public String projectinfo(){
        return "wx/projectinfo";
    }
}
