package com.jianpanmao.device.entity;

import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Device implements Serializable {
    //
    private Integer deviceId;

    private String operateUserStr;

    private String transcribeUserStr;

    //操作员ID
    private List<Contacts> operateUser;

    //抄表员ID
    private List<Contacts> transcribeUser;

    //项目ID
    private Project project;

    private Integer valid;

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    //中间商ID
    private Intermediary intermediary;

    //生产编号
    @NotBlank(message = "生产编号不能为空")
    @Size(min = 1, max = 20, message = "生成编号在1-20个字符")
    private String deviceProductionNum;

    //设备状态：0在线，1不在线
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
    private String deviceType;

    private String createTimeStr;

    private Timestamp sysTime;

    private Integer startOff;


    public String getOperateUserStr() {
        return operateUserStr;
    }

    public void setOperateUserStr(String operateUserStr) {
        this.operateUserStr = operateUserStr;
    }

    public String getTranscribeUserStr() {
        return transcribeUserStr;
    }

    public void setTranscribeUserStr(String transcribeUserStr) {
        this.transcribeUserStr = transcribeUserStr;
    }

    public Integer getStartOff() {
        return startOff;
    }

    public void setStartOff(Integer startOff) {
        this.startOff = startOff;
    }

    public Timestamp getSysTime() {
        return sysTime;
    }

    public void setSysTime(Timestamp sysTime) {
        this.sysTime = sysTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

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

    public List<Contacts> getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(List<Contacts> operateUser) {
        this.operateUser = operateUser;
    }

    public List<Contacts> getTranscribeUser() {
        return transcribeUser;
    }

    public void setTranscribeUser(List<Contacts> transcribeUser) {
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