package com.jianpanmao.device.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.device.dao.DeviceMapper;
import com.jianpanmao.device.dto.control.DeviceControlVo;
import com.jianpanmao.device.dto.control.DeviceParam;
import com.jianpanmao.device.dto.control.DeviceUserParam;
import com.jianpanmao.device.dto.control.SystemTime;
import com.jianpanmao.device.entity.*;
import com.jianpanmao.device.dto.*;
import com.jianpanmao.device.service.DeviceService;
import com.jianpanmao.intermediary.dao.IntermediaryMapper;
import com.jianpanmao.intermediary.entity.Intermediary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceExample, DeviceDto, Integer> implements DeviceService {

    @Autowired
    private IntermediaryMapper intermediaryMapper;

    @Autowired
    DeviceMapper deviceMapper;

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

    @Override
    public DeviceControlVo deviceControl(String num) {
        Device device = deviceMapper.byNum(num);
        DeviceControlVo deviceControlVo = new DeviceControlVo();
        deviceControlVo.setRemoteBoot(device.getStartOff());
        DeviceParam deviceParam = deviceMapper.selectDeviceParam(num);//设备参数
        DeviceUserParam deviceUserParam = deviceMapper.selectDeviceUserParam(num);//用户参数
        deviceControlVo.setDeviceParam(deviceParam);
        deviceControlVo.setDeviceUserParam(deviceUserParam);


        Timestamp timestamp = device.getSysTime();
        SystemTime systemTime = new SystemTime();
        if (null!=timestamp){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timestamp);
            systemTime.setYear(calendar.get(Calendar.YEAR));
            systemTime.setMonth(calendar.get(Calendar.MONTH) + 1);
            systemTime.setDay(calendar.get(Calendar.DAY_OF_MONTH));
            systemTime.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            systemTime.setMinute(calendar.get(Calendar.MINUTE));
            systemTime.setSecond(calendar.get(Calendar.SECOND));
        }

        deviceControlVo.setSystem_time(systemTime);
        return deviceControlVo;
    }
}