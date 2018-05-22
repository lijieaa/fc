package com.jianpanmao.wxpublic.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.wxpublic.entity.*;
import com.jianpanmao.wxpublic.dto.*;

import java.util.List;


public interface WxPublicService extends BaseService<WxPublic, WxPublicExample,WxPublicDto,Integer>{

    List<WxPublic> findByCompanyId(Integer companyId);
}