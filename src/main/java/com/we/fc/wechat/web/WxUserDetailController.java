package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.base.BaseTokenController;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.wechat.entity.WxUserDetail;
import com.we.fc.wechat.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-14 23:03
 */

@Controller
@RequestMapping("wxUsers")
public class WxUserDetailController extends BaseController<WxUserDetail> {

    @Autowired private WxUserDetailService wxUserDetailService;

    @Override
    public BaseService<WxUserDetail> getService() {
        return wxUserDetailService;
    }

    private BaseTokenController baseTokenController;

    public WxUserDetailController(){
        baseTokenController = new BaseTokenController();
    }

    @Override
    @GetMapping("page")
    @ResponseBody
    public ResponseEntity pageList(Integer page,
                                   Integer rows,
                                   WxUserDetail wxUserDetail,
                                   HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            baseTokenController.checkParam(session, wxUserDetail.getWxPublicId());
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            return responseEntity;
        }
        return super.pageList(page, rows, wxUserDetail, session);
    }
}
