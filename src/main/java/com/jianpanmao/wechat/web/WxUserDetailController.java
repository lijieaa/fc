package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.entity.WxUserDetail;
import com.jianpanmao.wechat.service.WxPublicService;
import com.jianpanmao.wechat.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired private WxPublicService wxPublicService;

    @PreAuthorize("hasAuthority('wxuser:view')")
    @GetMapping("page")
    @ResponseBody
    public Object pageList(Integer page,
                                             Integer rows,
                                             @RequestParam(value = "draw", required = false) Integer draw,
                                             @RequestParam("wxPublicId") Integer wxPublicId,
                                             WxUserDetail wxUserDetail,
                                             HttpSession session) throws Exception{
        WxUtils.checkParam(session, wxUserDetail.getWxPublicId());
        wxUserDetail.setWxPublic(wxPublicService.selectByPrimaryKey(wxPublicId));
        PageHelper.startPage(page, rows);
        List<WxUserDetail> list = wxUserDetailService.selectAll(wxUserDetail);
        PageInfo pageInfo = new PageInfo(list);
        if (draw != null) {
            DataTablesResponseEntity<Project> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }
}
