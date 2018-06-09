package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;

import java.util.List;


public interface ExtConService extends BaseService<ExtCon, ExtConExample,ExtConDto,Integer>{

    List<ExtCon> selectByLabId(Integer labId);

}