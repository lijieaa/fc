package com.jianpanmao.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jianpanmao.intermediary.entity.Intermediary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class DingtalkUser implements Serializable,UserDetails {
    //员工唯一标识ID（不可修改），企业内必须唯一。长度为1~64个字符，如果不传，服务器将自动生成一个userid
    private Integer userid;

    //成员名称。长度为1~64个字符
    @NotNull(message = "name不能为空！")
    private String name;

    //职位信息。长度为0~64个字符
    private String position;

    //手机号码，企业内必须唯一，不可重复
    @NotNull(message = "mobile不能为空！")
    private String mobile;

    //分机号，长度为0~50个字符，企业内必须唯一，不可重复
    private String tel;

    //办公地点，长度为0~50个字符
    private String workplace;

    //备注，长度为0~1000个字符
    private String remark;

    //邮箱。长度为0~64个字符。企业内必须唯一，不可重复
    private String email;

    //员工的企业邮箱，员工的企业邮箱已开通，才能增加此字段， 否则会报错
    private String orgemail;

    //员工工号。对应显示到OA后台和客户端个人资料的工号栏目。长度为0~64个字符
    private String jobnumber;

    //是否号码隐藏, true表示隐藏, false表示不隐藏。隐藏手机号后，手机号在个人资料页隐藏，但仍可对其发DING、发起钉钉免费商务电话。
    private Boolean ishide;

    //是否高管模式，true表示是，false表示不是。开启后，手机号码对所有员工隐藏。普通员工无法对其发DING、发起钉钉免费商务电话。高管之间不受影响。
    private Boolean issenior;

    //中间商ID
    private Integer intermediaryId;

    //
    private Date createTime;

    //
    private Date updateTime;

    //
    private Integer isAdmin;

    //
    private String password;

    //扩展属性，可以设置多种属性(但手机上最多只能显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置)
    private String extattr;

    private Intermediary intermediary;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace == null ? null : workplace.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOrgemail() {
        return orgemail;
    }

    public void setOrgemail(String orgemail) {
        this.orgemail = orgemail == null ? null : orgemail.trim();
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber == null ? null : jobnumber.trim();
    }

    public Boolean getIshide() {
        return ishide;
    }

    public void setIshide(Boolean ishide) {
        this.ishide = ishide;
    }

    public Boolean getIssenior() {
        return issenior;
    }

    public void setIssenior(Boolean issenior) {
        this.issenior = issenior;
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

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getExtattr() {
        return extattr;
    }

    public void setExtattr(String extattr) {
        this.extattr = extattr == null ? null : extattr.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", name=").append(name);
        sb.append(", position=").append(position);
        sb.append(", mobile=").append(mobile);
        sb.append(", tel=").append(tel);
        sb.append(", workplace=").append(workplace);
        sb.append(", remark=").append(remark);
        sb.append(", email=").append(email);
        sb.append(", orgemail=").append(orgemail);
        sb.append(", jobnumber=").append(jobnumber);
        sb.append(", ishide=").append(ishide);
        sb.append(", issenior=").append(issenior);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", password=").append(password);
        sb.append(", extattr=").append(extattr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }
}