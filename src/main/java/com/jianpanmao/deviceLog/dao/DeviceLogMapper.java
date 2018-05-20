package com.jianpanmao.deviceLog.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.deviceLog.dto.DeviceLogDto;
import com.jianpanmao.deviceLog.entity.DeviceLog;
import com.jianpanmao.deviceLog.entity.DeviceLogExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceLogMapper extends BaseDao<DeviceLog, DeviceLogExample, DeviceLogDto, Integer> {
}