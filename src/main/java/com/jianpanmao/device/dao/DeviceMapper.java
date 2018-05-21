package com.jianpanmao.device.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.device.dto.DeviceDto;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.entity.DeviceExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseDao<Device, DeviceExample, DeviceDto, Integer> {
    List<Device> findByProject(Integer projectId);
}