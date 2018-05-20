package com.jianpanmao.device.entity;

import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Device implements Serializable {
    //
    private Integer deviceId;

    //操作员ID
    private DingtalkUser operateUser;

    //抄表员ID
    private DingtalkUser transcribeUser;

    //项目ID
    private Project project;

    //中间商ID
    private @NotNull(message = "中间商不能为空") Intermediary intermediary;

    //生产编号
    @NotBlank(message = "生产编号不能为空")
    @Size(min = 1, max = 20, message = "生成编号在1-20个字符")
    private String deviceProductionNum;

    //设备状态：0在线，1不在线
    @NotNull(message = "设备状态不能为空")
    private Byte deviceStatus;

    //设备X坐标
    @Size(min = 1, max = 20, message = "x坐标在1-20个字符")
    private String deviceLocationX;

    //设备Y坐标

    @Size(min = 1, max = 20, message = "y坐标在1-20个字符")
    private String deviceLocationY;

    //创建时间
    private Date deviceCreateTime;

    //更新时间
    private Date deviceUpdateTime;

    //设备生产厂商ID
    private Integer manufacturerId;

    //用户名
    private String userName;

    //密码
    private String password;

    //设备型号
    @NotNull(message = "设备型号不能为空！")
    private String deviceType;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceProductionNum() {
        return deviceProductionNum;
    }

    public void setDeviceProductionNum(String deviceProductionNum) {
        this.deviceProductionNum = deviceProductionNum == null ? null : deviceProductionNum.trim();
    }

    public Byte getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Byte deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceLocationX() {
        return deviceLocationX;
    }

    public void setDeviceLocationX(String deviceLocationX) {
        this.deviceLocationX = deviceLocationX == null ? null : deviceLocationX.trim();
    }

    public String getDeviceLocationY() {
        return deviceLocationY;
    }

    public void setDeviceLocationY(String deviceLocationY) {
        this.deviceLocationY = deviceLocationY == null ? null : deviceLocationY.trim();
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

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }

    public Date getDeviceCreateTime() {
        return deviceCreateTime;
    }

    public void setDeviceCreateTime(Date deviceCreateTime) {
        this.deviceCreateTime = deviceCreateTime;
    }

    public Date getDeviceUpdateTime() {
        return deviceUpdateTime;
    }

    public void setDeviceUpdateTime(Date deviceUpdateTime) {
        this.deviceUpdateTime = deviceUpdateTime;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

}