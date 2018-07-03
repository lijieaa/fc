package com.jianpanmao.device.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.device.dto.DeviceDto;
import com.jianpanmao.device.dto.DpDto;
import com.jianpanmao.device.dto.control.DeviceParam;
import com.jianpanmao.device.dto.control.DeviceUserParam;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.entity.DeviceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseDao<Device, DeviceExample, DeviceDto, Integer> {
    List<Device> findByProject(Integer projectId);
    void updateDeviceUser(DeviceDto deviceDto);

    List<Device> freeDeviceList(@Param("num") String num,@Param("od")String od);

    void updateProjectId(DpDto dpDto);

    List<Device> homePageDevice(Integer intermediaryId);

    Device byNum(String num);

    /* 设备控制 */
    DeviceParam selectDeviceParam(String num);
    DeviceUserParam selectDeviceUserParam(String num);
}