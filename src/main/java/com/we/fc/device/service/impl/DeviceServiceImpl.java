package com.we.fc.device.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.device.dao.DeviceMapper;
import com.we.fc.device.entity.Device;
import com.we.fc.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/4/15.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements DeviceService {

    @Autowired
    DeviceMapper dao;

    @Override
    public BaseDao<Device> getDao() {
        return dao;
    }
}
