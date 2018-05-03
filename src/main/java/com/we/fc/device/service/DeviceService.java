package com.we.fc.device.service;

import com.we.fc.base.BaseService;
import com.we.fc.device.entity.Device;

import java.util.List;

/**
 * Created by mayn on 2018/4/15.
 */
public interface DeviceService extends BaseService<Device> {
    List<Device> findByProject(Integer projectId);
}
