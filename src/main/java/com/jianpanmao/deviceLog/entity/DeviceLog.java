package com.jianpanmao.deviceLog.entity;

import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeviceLog implements Serializable {
    //
    private Integer deviceLogId;

    //设备生产编号
    @NotBlank(message = "设备生产编号不能为空")
    @Size(min = 1, max = 20, message = "生成编号在1-20个字符")
    private String deviceProductionNum;

    //操作指令
    @NotBlank(message = "操作指令不能为空")
    @Size(min = 1, max = 20, message = "操作指令在1-20个字符")
    private String operateCommand;

    //操作指令描述
    @NotBlank(message = "操作指令描述不能为空")
    @Size(min = 1, max = 20, message = "操作指令描述在1-20个字符")
    private String operateCommandDesc;

    //操作人
    @NotNull(message = "操作人不能为空")
    private DingtalkUser user;

    //创建时间
    private Date deviceLogCreateTime;

    //更新时间
    private Date deviceLogUpdateTime;

    private String createTimeStr;

    private String deviceOperationContent;

    public String getDeviceOperationContent() {
        return deviceOperationContent;
    }

    public void setDeviceOperationContent(String deviceOperationContent) {
        this.deviceOperationContent = deviceOperationContent;
    }

    private static final long serialVersionUID = 1L;

    String od;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Integer getDeviceLogId() {
        return deviceLogId;
    }

    public void setDeviceLogId(Integer deviceLogId) {
        this.deviceLogId = deviceLogId;
    }

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


    public Date getDeviceLogCreateTime() {
        return deviceLogCreateTime;
    }

    public void setDeviceLogCreateTime(Date deviceLogCreateTime) {
        this.deviceLogCreateTime = deviceLogCreateTime;
    }

    public Date getDeviceLogUpdateTime() {
        return deviceLogUpdateTime;
    }

    public void setDeviceLogUpdateTime(Date deviceLogUpdateTime) {
        this.deviceLogUpdateTime = deviceLogUpdateTime;
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }
}