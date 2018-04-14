package com.we.fc.wechat.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxUserDetail;
import com.we.fc.wechat.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
