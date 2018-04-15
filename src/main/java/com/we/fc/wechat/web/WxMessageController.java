package com.we.fc.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.user.entity.User;
import com.we.fc.wechat.entity.WxMessage;
import com.we.fc.wechat.entity.WxPublic;
import com.we.fc.wechat.service.WxMessageService;
import com.we.fc.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-15 18:03
 */

@Controller
@RequestMapping("message")
public class WxMessageController{

    @Autowired private WxMessageService wxMessageService;

    @Autowired private WxPublicService wxPublicService;

    @GetMapping("page")
    @ResponseBody
    public ResponseEntity page(Integer page,
                               Integer rows,
                               String openId,
                               HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            User user = (User)session.getAttribute("user");
            WxPublic wxPublic = wxPublicService.findByCompanyId(user.getCompany().getId());
            PageHelper.startPage(page,rows);
            List<WxMessage> list = wxMessageService.findBySourceIdAndOpenId(wxPublic.getSourceId(), openId);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(Arrays.asList(pageInfo));
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("获取失败");
            return responseEntity;
        }
    }
}
