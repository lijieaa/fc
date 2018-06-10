package com.jianpanmao.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ExtCon implements Serializable {
    //主键
    private Integer id;

    //用户名
    @NotNull(message = "username不能为空！")
    private String username;

    //电话
    @NotNull(message = "tel不能为空！")
    private String tel;

    //公司名称
    private String company;

    //职位
    private String pos;

    //邮箱
    private String email;

    //地址
    private String adress;

    //备注
    private String mark;

    //负责人
    private Integer charge;

    //中间商ID
    private Integer intermediaryId;

    //创建时间
    private Date createTime;

    //最后更新时间
    private Date updateTime;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", tel=").append(tel);
        sb.append(", company=").append(company);
        sb.append(", pos=").append(pos);
        sb.append(", email=").append(email);
        sb.append(", adress=").append(adress);
        sb.append(", mark=").append(mark);
        sb.append(", charge=").append(charge);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public List<ExtConLab> getLabs() {
        return labs;
    }

    public void setLabs(List<ExtConLab> labs) {
        this.labs = labs;
    }

    private List<ExtConLab> labs=new ArrayList<>();


    public DingtalkUser getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(DingtalkUser changeUser) {
        this.changeUser = changeUser;
    }

    private DingtalkUser changeUser;


}