package com.we.fc.device.dao;


import com.we.fc.base.BaseDao;
import com.we.fc.device.entity.Device;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseDao<Device>{

    List<Device> findByProject(Integer projectId);
}