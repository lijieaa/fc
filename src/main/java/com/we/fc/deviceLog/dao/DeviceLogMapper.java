package com.we.fc.deviceLog.dao;

import com.we.fc.deviceLog.entity.DeviceLog;
import java.util.List;

public interface DeviceLogMapper {
    int deleteByPrimaryKey(Integer deviceLogId);

    int insert(DeviceLog record);

    DeviceLog selectByPrimaryKey(Integer deviceLogId);

    List<DeviceLog> selectAll();

    int updateByPrimaryKey(DeviceLog record);
}