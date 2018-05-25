package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.entity.WxUserDetail;
import com.jianpanmao.wechat.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-14 23:03
 */

@Controller
@RequestMapping("wxUsers")
public class WxUserDetailController  {

    @Autowired private WxUserDetailService wxUserDetailService;

    @GetMapping("page")
    @ResponseBody
    public ResponseEntity pageList(Integer page,
                                   Integer rows,
                                   WxUserDetail wxUserDetail,
                                   HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            WxUtils.checkParam(session, wxUserDetail.getWxPublicId());
            PageHelper.startPage(page, rows);
            wxUserDetail.setIntermediary(WxUtils.getCompany(session));
            List<WxUserDetail> list = wxUserDetailService.selectAll(wxUserDetail);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(pageInfo);
            return responseEntity;
        } catch (Exception e) {
            responseEntity.setMessages(e.getMessage());
            responseEntity.setStatus("500");
            return responseEntity;
        }
    }
}
