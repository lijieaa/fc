package com.jianpanmao.wechat.wx;

import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zdc
 * @since 2018-07-06 22:18
 */
@RequestMapping("wx/common")
@RestController
public class WxCommonRestController {

    @Autowired private WxPublicService wxPublicService;

    @ResponseBody
    @RequestMapping("companyInfo")
    public Intermediary findBySourceId(String sourceId) throws Exception {
        return wxPublicService.findBySourceId(sourceId).getIntermediary();
    }
}
