package com.jianpanmao.customer.dto;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerDto {


private Date cusUpdateTime ;

public Date getCusUpdateTime() {
return cusUpdateTime;
}

public void setCusUpdateTime(Date cusUpdateTime) {
this.cusUpdateTime = cusUpdateTime;
}
private Integer cusId ;

public Integer getCusId() {
return cusId;
}

public void setCusId(Integer cusId) {
this.cusId = cusId;
}
private String od ;

public String getOd() {
return od;
}

public void setOd(String od) {
this.od = od;
}
private String cusComTel ;

public String getCusComTel() {
return cusComTel;
}

public void setCusComTel(String cusComTel) {
this.cusComTel = cusComTel;
}
private Date cusCreateTime ;

public Date getCusCreateTime() {
return cusCreateTime;
}

public void setCusCreateTime(Date cusCreateTime) {
this.cusCreateTime = cusCreateTime;
}
private String cusComEmail ;

public String getCusComEmail() {
return cusComEmail;
}

public void setCusComEmail(String cusComEmail) {
this.cusComEmail = cusComEmail;
}
private String cusComName ;

public String getCusComName() {
return cusComName;
}

public void setCusComName(String cusComName) {
this.cusComName = cusComName;
}
private Integer intermediaryId ;

public Integer getIntermediaryId() {
return intermediaryId;
}

public void setIntermediaryId(Integer intermediaryId) {
this.intermediaryId = intermediaryId;
}
private String cusComAdr ;

public String getCusComAdr() {
return cusComAdr;
}

public void setCusComAdr(String cusComAdr) {
this.cusComAdr = cusComAdr;
}
}