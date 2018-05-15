package com.we.fc.deviceLog.entity;

import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DeviceLog extends BaseEntity implements Serializable {

    @NotBlank(message = "设备生产编号不能为空")
    @Size(min = 1,max = 20,message = "生成编号在1-20个字符")
    private String deviceProductionNum;

    @NotBlank(message = "操作指令不能为空")
    @Size(min = 1,max = 20,message = "操作指令在1-20个字符")
    private String operateCommand;

    @NotBlank(message = "操作指令描述不能为空")
    @Size(min = 1,max = 20,message = "操作指令描述在1-20个字符")
    private String operateCommandDesc;

    @NotNull(message = "操作人不能为空")
    private DingtalkUser user;

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

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

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
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