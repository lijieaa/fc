package com.we.fc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-03-28 19:50
 */
@Controller
public class IndexController {

    @GetMapping("login")
    public String login(HttpSession session){
        if(session.getAttribute("user") != null){
            return "redirect:index";
        }
        return "login";
    }
    @GetMapping("index")
    public String index(){
        return "index";
    }

}
