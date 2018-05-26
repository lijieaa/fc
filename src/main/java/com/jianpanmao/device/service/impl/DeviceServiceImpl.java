package com.jianpanmao.device.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.device.entity.*;
import com.jianpanmao.device.dto.*;
import com.jianpanmao.device.service.DeviceService;
import com.jianpanmao.intermediary.dao.IntermediaryMapper;
import com.jianpanmao.intermediary.entity.Intermediary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceExample, DeviceDto, Integer> implements DeviceService {

    @Autowired
    private IntermediaryMapper intermediaryMapper;

    @Override
    public int add(Device record) {
        Intermediary intermediary = intermediaryMapper.byIsPlat();
        record.setIntermediary(intermediary);
        record.setDeviceStatus(new Byte("1"));
        record.setValid(0);
        return super.add(record);
    }
}