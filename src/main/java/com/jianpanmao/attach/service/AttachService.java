package com.jianpanmao.attach.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.attach.entity.*;
import com.jianpanmao.attach.dto.*;

import javax.servlet.http.HttpServletResponse;


public interface AttachService extends BaseService<Attach, AttachExample,AttachDto,Integer>{
    void downFile(Integer id,HttpServletResponse response);
}