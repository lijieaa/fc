package com.we.fc.deviceLog.service.impl;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.deviceLog.dao.DeviceLogMapper;
import com.we.fc.deviceLog.entity.DeviceLog;
import com.we.fc.deviceLog.service.DeviceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayn on 2018/4/25.
 */
@Service
public class DeviceLogServiceImpl extends BaseServiceImpl<DeviceLog> implements DeviceLogService {

    @Autowired
    private DeviceLogMapper dao;

    @Override
    public BaseDao<DeviceLog> getDao() {
        return dao;
    }
}
