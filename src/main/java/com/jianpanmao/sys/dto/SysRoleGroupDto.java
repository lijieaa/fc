package com.jianpanmao.sys.dto;
import java.math.BigDecimal;
import java.util.Date;

public class SysRoleGroupDto {


private Date roleGroupCreateTime ;

public Date getRoleGroupCreateTime() {
return roleGroupCreateTime;
}

public void setRoleGroupCreateTime(Date roleGroupCreateTime) {
this.roleGroupCreateTime = roleGroupCreateTime;
}
private String od ;

public String getOd() {
return od;
}

public void setOd(String od) {
this.od = od;
}
private Integer roleId ;

public Integer getRoleId() {
return roleId;
}

public void setRoleId(Integer roleId) {
this.roleId = roleId;
}
private String roleName ;

public String getRoleName() {
return roleName;
}

public void setRoleName(String roleName) {
this.roleName = roleName;
}
private Integer isDel ;

public Integer getIsDel() {
return isDel;
}

public void setIsDel(Integer isDel) {
this.isDel = isDel;
}
private Integer intermediaryId ;

public Integer getIntermediaryId() {
return intermediaryId;
}

public void setIntermediaryId(Integer intermediaryId) {
this.intermediaryId = intermediaryId;
}
private Date roleGroupUpdateTime ;

public Date getRoleGroupUpdateTime() {
return roleGroupUpdateTime;
}

public void setRoleGroupUpdateTime(Date roleGroupUpdateTime) {
this.roleGroupUpdateTime = roleGroupUpdateTime;
}
}