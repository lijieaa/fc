package com.jianpanmao.device.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.contacts.dao.ContactsMapper;
import com.jianpanmao.contacts.entity.Contacts;
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
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceExample, DeviceDto, Integer> implements DeviceService {

    @Autowired
    private IntermediaryMapper intermediaryMapper;

    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    ContactsMapper contactsMapper;

    @Override
    public List<Device> getByDto(DeviceDto dto) {
        List<Device> devices =super.getByDto(dto);
        for (Device device:devices){
            String  stringOP =new String("");
            String stringTR =new String("");
            List<Contacts> contactses = contactsMapper.deviceContacts(device.getDeviceId());
            for (Contacts contacts:contactses){
                if (contacts.getContactsStatus().intValue()==0){
                    stringTR += contacts.getConName()+",";
                }else if (contacts.getContactsStatus().intValue()==1){
                    stringOP +=contacts.getConName()+",";
                }
            }
            if (stringOP.length()>0){
                stringOP = stringOP.substring(0,stringOP.length()-1);
            }
            if (stringTR.length()>0){
                stringTR = stringTR.substring(0,stringTR.length()-1);
            }
            device.setTranscribeUserStr(stringTR);
            device.setOperateUserStr(stringOP);
        }

        return devices;
    }

    @Override
    public Device get(Integer TId) {
        Device device = super.get(TId);
        List<Contacts> contactses = contactsMapper.deviceContacts(TId);
        device.setContactses(contactses);
        return device;
    }

    @Override
    @Transactional
    public int update(Device record) {
        if (record.getIntermediary()==null){
            Intermediary intermediary = intermediaryMapper.byIsPlat();
            record.setIntermediary(intermediary);
        }
        deviceMapper.deleteByDId(record.getDeviceId());
        //操作员
        String operateIds = record.getOperateUserStr();
        if (operateIds!=null&&operateIds.length()>0){
            addContacts(operateIds,record.getDeviceId(),1);
        }
        //抄表员
        String transcribeIds = record.getTranscribeUserStr();
        if (transcribeIds!=null&&transcribeIds.length()>0){
            addContacts(transcribeIds,record.getDeviceId(),0);
        }
        return super.update(record);
    }

    void addContacts(String ids,Integer deviceId,Integer status){
        String[] arrayIds = ids.split(",");
        List<DeviceContacts> deviceContactsList = new ArrayList<>();
        for (String id:arrayIds){
            DeviceContacts deviceContacts = new DeviceContacts();
            deviceContacts.setDeviceContactsDId(deviceId);
            deviceContacts.setDeviceContactsCId(Integer.valueOf(id));
            deviceContacts.setDeviceContactsStatus(status);
            deviceContactsList.add(deviceContacts);
        }
        deviceMapper.addContacts(deviceContactsList);
    }

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