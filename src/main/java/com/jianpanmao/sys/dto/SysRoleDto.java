package com.jianpanmao.sys.dto;
import java.math.BigDecimal;
import java.util.Date;

public class SysRoleDto {


private Date roleCreateTime ;

public Date getRoleCreateTime() {
return roleCreateTime;
}

public void setRoleCreateTime(Date roleCreateTime) {
this.roleCreateTime = roleCreateTime;
}
private Date roleUpdateTime ;

public Date getRoleUpdateTime() {
return roleUpdateTime;
}

public void setRoleUpdateTime(Date roleUpdateTime) {
this.roleUpdateTime = roleUpdateTime;
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
private Integer pid ;

public Integer getPid() {
return pid;
}

public void setPid(Integer pid) {
this.pid = pid;
}
private String roleDescription ;

public String getRoleDescription() {
return roleDescription;
}

public void setRoleDescription(String roleDescription) {
this.roleDescription = roleDescription;
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
}