package com.jianpanmao.device.dto.control;

/**
 * Created by mayn on 2018/5/27.
 * 设备控制页返回Vo
 */

public class DeviceControlVo {
    private Integer remoteBoot;     //设备远程启停
    private DeviceParam deviceParam;//设备参数
    private DeviceUserParam deviceUserParam;//用户参数
    private SystemTime systemTime; //系统时间


    public Integer getRemoteBoot() {
        return remoteBoot;
    }

    public void setRemoteBoot(Integer remoteBoot) {
        this.remoteBoot = remoteBoot;
    }

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

    public SystemTime getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(SystemTime systemTime) {
        this.systemTime = systemTime;
    }
}
