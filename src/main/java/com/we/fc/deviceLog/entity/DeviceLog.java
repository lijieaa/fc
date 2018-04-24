package com.we.fc.deviceLog.entity;

import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.User;

import java.io.Serializable;
import java.util.Date;

public class DeviceLog extends BaseEntity implements Serializable {

    private String deviceProductionNum;

    private String operateCommand;

    private String operateCommandDesc;

    private User user;


    private static final long serialVersionUID = 1L;


    public String getDeviceProductionNum() {
        return deviceProductionNum;
    }

    public void setDeviceProductionNum(String deviceProductionNum) {
        this.deviceProductionNum = deviceProductionNum == null ? null : deviceProductionNum.trim();
    }

    public String getOperateCommand() {
        return operateCommand;
    }

    public void setOperateCommand(String operateCommand) {
        this.operateCommand = operateCommand == null ? null : operateCommand.trim();
    }

    public String getOperateCommandDesc() {
        return operateCommandDesc;
    }

    public void setOperateCommandDesc(String operateCommandDesc) {
        this.operateCommandDesc = operateCommandDesc == null ? null : operateCommandDesc.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceProductionNum=").append(deviceProductionNum);
        sb.append(", operateCommand=").append(operateCommand);
        sb.append(", operateCommandDesc=").append(operateCommandDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}