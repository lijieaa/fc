package com.jianpanmao.device.dto.control;

import java.util.Date;

/**
 * Created by mayn on 2018/5/27.
 * 用户参数
 */
public class DeviceUserParam {
    private Long id;
    private String deviceProductionNum;
    private Integer clearCyc;
    private Integer unitInterval;
    private Integer mainValveDelayTime;
    private Integer pDelayTime;
    private Integer pThreshold;
    private Integer pClearTime;
    private Integer pWarning;
    private Integer powerCyc;
    private Integer pPowerThreshold;
    private Date updateTime;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceProductionNum() {
        return deviceProductionNum;
    }

    public void setDeviceProductionNum(String deviceProductionNum) {
        this.deviceProductionNum = deviceProductionNum;
    }

    public Integer getClearCyc() {
        return clearCyc;
    }

    public void setClearCyc(Integer clearCyc) {
        this.clearCyc = clearCyc;
    }

    public Integer getUnitInterval() {
        return unitInterval;
    }

    public void setUnitInterval(Integer unitInterval) {
        this.unitInterval = unitInterval;
    }

    public Integer getMainValveDelayTime() {
        return mainValveDelayTime;
    }

    public void setMainValveDelayTime(Integer mainValveDelayTime) {
        this.mainValveDelayTime = mainValveDelayTime;
    }

    public Integer getpDelayTime() {
        return pDelayTime;
    }

    public void setpDelayTime(Integer pDelayTime) {
        this.pDelayTime = pDelayTime;
    }

    public Integer getpThreshold() {
        return pThreshold;
    }

    public void setpThreshold(Integer pThreshold) {
        this.pThreshold = pThreshold;
    }

    public Integer getpClearTime() {
        return pClearTime;
    }

    public void setpClearTime(Integer pClearTime) {
        this.pClearTime = pClearTime;
    }

    public Integer getpWarning() {
        return pWarning;
    }

    public void setpWarning(Integer pWarning) {
        this.pWarning = pWarning;
    }

    public Integer getPowerCyc() {
        return powerCyc;
    }

    public void setPowerCyc(Integer powerCyc) {
        this.powerCyc = powerCyc;
    }

    public Integer getpPowerThreshold() {
        return pPowerThreshold;
    }

    public void setpPowerThreshold(Integer pPowerThreshold) {
        this.pPowerThreshold = pPowerThreshold;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
};
