package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zdc
 * @since 2018-04-05 21:46
 */

@Controller
@RequestMapping("wx")
public class WechatController extends BaseController {
    @Override
    public BaseService getService() {
        return null;
    }

    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "wx/index";
    }
}
