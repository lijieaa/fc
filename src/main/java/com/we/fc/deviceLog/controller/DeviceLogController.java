package com.we.fc.deviceLog.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.deviceLog.entity.DeviceLog;
import com.we.fc.deviceLog.service.DeviceLogService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mayn on 2018/4/25.
 */
@Controller
@RequestMapping("deviceLog")
public class DeviceLogController extends BaseController<DeviceLog> {

    @Autowired
    private DeviceLogService service;

    @Override
    public BaseService<DeviceLog> getService() {
        return service;
    }

    @Override
    protected ResponseEntity hookExist(DeviceLog deviceLog) {
        return null;
    }
}
