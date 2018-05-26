package com.jianpanmao.device.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.device.entity.*;
import com.jianpanmao.device.dto.*;
import com.jianpanmao.device.service.DeviceService;
import com.jianpanmao.intermediary.dao.IntermediaryMapper;
import com.jianpanmao.intermediary.entity.Intermediary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceExample, DeviceDto, Integer> implements DeviceService {

    @Autowired
    private IntermediaryMapper intermediaryMapper;

    @Override
    public void batAdd(List<Device> devices) {
        Intermediary intermediary = intermediaryMapper.byIsPlat();
        for (Device device : devices) {
            device.setIntermediary(intermediary);
            device.setDeviceStatus(new Byte("1"));
            device.setValid(0);
            super.add(device);
        }
    }
}