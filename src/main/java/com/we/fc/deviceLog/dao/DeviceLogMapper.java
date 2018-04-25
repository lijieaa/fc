package com.we.fc.deviceLog.dao;

import com.we.fc.base.BaseDao;
import com.we.fc.deviceLog.entity.DeviceLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceLogMapper extends BaseDao<DeviceLog> {

}