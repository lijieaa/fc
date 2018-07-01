package com.jianpanmao.device.dto;

import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.sys.entity.DingtalkUser;

import java.util.Date;

public class DeviceDto {


    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    private Integer manufacturerId;

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private Integer deviceId;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    private Byte deviceStatus;

    public Byte getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Byte deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Date deviceUpdateTime;

    public Date getDeviceUpdateTime() {
        return deviceUpdateTime;
    }

    public void setDeviceUpdateTime(Date deviceUpdateTime) {
        this.deviceUpdateTime = deviceUpdateTime;
    }

    private String deviceLocationX;

    public String getDeviceLocationX() {
        return deviceLocationX;
    }

    public void setDeviceLocationX(String deviceLocationX) {
        this.deviceLocationX = deviceLocationX;
    }

    private String od;

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    private String deviceLocationY;

    public String getDeviceLocationY() {
        return deviceLocationY;
    }

    public void setDeviceLocationY(String deviceLocationY) {
        this.deviceLocationY = deviceLocationY;
    }

    private DingtalkUser operateUser;

    private DingtalkUser transcribeUser;

    private Project project;

    private Intermediary intermediary;

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    private String deviceProductionNum;

    public String getDeviceProductionNum() {
        return deviceProductionNum;
    }

    public void setDeviceProductionNum(String deviceProductionNum) {
        this.deviceProductionNum = deviceProductionNum;
    }

    private Date deviceCreateTime;

    public Date getDeviceCreateTime() {
        return deviceCreateTime;
    }

    public void setDeviceCreateTime(Date deviceCreateTime) {
        this.deviceCreateTime = deviceCreateTime;
    }

    public DingtalkUser getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(DingtalkUser operateUser) {
        this.operateUser = operateUser;
    }

    public DingtalkUser getTranscribeUser() {
        return transcribeUser;
    }

    public void setTranscribeUser(DingtalkUser transcribeUser) {
        this.transcribeUser = transcribeUser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}