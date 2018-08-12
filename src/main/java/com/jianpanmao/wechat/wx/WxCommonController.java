package com.jianpanmao.wechat.wx;

import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 公众号页面
 * @author zdc
 * @since 2018-04-07 16:42
 */
@Controller
@RequestMapping("wx/common")
public class WxCommonController {

    @Autowired private ContactsService contactsService;

    @GetMapping("company")
    public String company(String sourceId, Model model){

        model.addAttribute("sourceId", sourceId);
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

    @GetMapping("equiprams")
    public String equiprams(){
        return "wx/equiprams";
    }

    @GetMapping("project")
    public String project(String sourceId, Model model){

        model.addAttribute("sourceId", sourceId);
        return "wx/project";
    }

    @GetMapping("projectinfo")
    public String projectinfo(){
        return "wx/projectinfo";
    }

    @GetMapping("sysparams")
    public String sysparams(){
        return "wx/sysparams";
    }
    @GetMapping("userparams")
    public String userparams(){
        return "wx/userparams";
    }
    @GetMapping("loginwx")
    public String loginwx(){
        return "wx/loginwx";
    }
    @GetMapping("changer")
    public String changer(){
        return "wx/changer";
    }
    @GetMapping("client")
    public String client(){
        return "wx/client";
    }
    @PostMapping("login")
    public String loginAction(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws Exception{

        Contacts contacts = contactsService.findeByTel(username);
        String pwd = contacts.getPwd();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, pwd)) {
            session.setAttribute("wxuser", contacts);
            return "redirect:/wd/operate";
        } else {
            return "redirect:/wx/common/loginwx";
        }
    }
}
