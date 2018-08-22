package com.jianpanmao.device.entity;

/**
 * Created by mayn on 2018/8/20.
 * 设备抄表员，操作员中间表
 */
public class DeviceContacts {
    private Integer deviceContactsId;
    private Integer deviceContactsDId;
    private Integer deviceContactsCId;
    private Integer deviceContactsStatus;

    public Integer getDeviceContactsId() {
        return deviceContactsId;
    }

    public void setDeviceContactsId(Integer deviceContactsId) {
        this.deviceContactsId = deviceContactsId;
    }

    public Integer getDeviceContactsDId() {
        return deviceContactsDId;
    }

    public void setDeviceContactsDId(Integer deviceContactsDId) {
        this.deviceContactsDId = deviceContactsDId;
    }

    public Integer getDeviceContactsCId() {
        return deviceContactsCId;
    }

    public void setDeviceContactsCId(Integer deviceContactsCId) {
        this.deviceContactsCId = deviceContactsCId;
    }

    public Integer getDeviceContactsStatus() {
        return deviceContactsStatus;
    }

    public void setDeviceContactsStatus(Integer deviceContactsStatus) {
        this.deviceContactsStatus = deviceContactsStatus;
    }
}
