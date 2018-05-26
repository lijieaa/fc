package com.jianpanmao.device.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.device.entity.*;
import com.jianpanmao.device.dto.*;

import java.util.List;


public interface DeviceService extends BaseService<Device, DeviceExample,DeviceDto,Integer>{

    void batAdd(List<Device> devices);

}