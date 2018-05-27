package com.jianpanmao.device.dto.control;

/**
 * Created by mayn on 2018/5/27.
 * 设备控制页返回Vo
 */

public class DeviceControlVo {
    private DeviceParam deviceParam;
    private DeviceUserParam deviceUserParam;

    public DeviceParam getDeviceParam() {
        return deviceParam;
    }

    public void setDeviceParam(DeviceParam deviceParam) {
        this.deviceParam = deviceParam;
    }

    public DeviceUserParam getDeviceUserParam() {
        return deviceUserParam;
    }

    public void setDeviceUserParam(DeviceUserParam deviceUserParam) {
        this.deviceUserParam = deviceUserParam;
    }
}
