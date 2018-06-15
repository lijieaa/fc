package com.jianpanmao.deviceLog.dto;

import com.jianpanmao.sys.entity.DingtalkUser;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceLogDto {


    private String operateCommand;

    public String getOperateCommand() {
        return operateCommand;
    }

    public void setOperateCommand(String operateCommand) {
        this.operateCommand = operateCommand;
    }

    private Date deviceLogCreateTime;

    public Date getDeviceLogCreateTime() {
        return deviceLogCreateTime;
    }

    public void setDeviceLogCreateTime(Date deviceLogCreateTime) {
        this.deviceLogCreateTime = deviceLogCreateTime;
    }

    private Integer deviceLogId;

    public Integer getDeviceLogId() {
        return deviceLogId;
    }

    public void setDeviceLogId(Integer deviceLogId) {
        this.deviceLogId = deviceLogId;
    }

    private Date deviceLogUpdateTime;

    public Date getDeviceLogUpdateTime() {
        return deviceLogUpdateTime;
    }

    public void setDeviceLogUpdateTime(Date deviceLogUpdateTime) {
        this.deviceLogUpdateTime = deviceLogUpdateTime;
    }

    private String operateCommandDesc;

    public String getOperateCommandDesc() {
        return operateCommandDesc;
    }

    public void setOperateCommandDesc(String operateCommandDesc) {
        this.operateCommandDesc = operateCommandDesc;
    }

    private String od;

    private String createTimeStr;

    private String endTimeStr;

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    private DingtalkUser user;

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    private String deviceProductionNum;

    public String getDeviceProductionNum() {
        return deviceProductionNum;
    }

    public void setDeviceProductionNum(String deviceProductionNum) {
        this.deviceProductionNum = deviceProductionNum;
    }
}