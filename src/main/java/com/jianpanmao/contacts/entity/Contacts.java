package com.jianpanmao.contacts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Contacts implements Serializable,UserDetails {
    //
    private Integer conId;

    //联系人姓名
    @NotNull(message = "conName不能为空！")
    private String conName;

    //联系人电话
    @NotNull(message = "conTel不能为空！")
    private String conTel;

    //联系人qq
    private String conQq;

    //联系人微信
    private String conWechat;

    //联系人邮箱
    private String conEmail;

    //客户外键
    private Integer cusId;

    //中间商外键
    private Integer intermediaryId;

    @JsonIgnore
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String pwd; //微信登录密码

    //创建时间
    private Date conCreateTime;

    //最后更新时间
    private Date conUpdateTime;

    private Integer contactsStatus;

    public Integer getContactsStatus() {
        return contactsStatus;
    }

    public void setContactsStatus(Integer contactsStatus) {
        this.contactsStatus = contactsStatus;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    private List<SysRole> roles=new ArrayList<>();

    private static final long serialVersionUID = 1L;


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel == null ? null : conTel.trim();
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq == null ? null : conQq.trim();
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat == null ? null : conWechat.trim();
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail == null ? null : conEmail.trim();
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public Date getConCreateTime() {
        return conCreateTime;
    }

    public void setConCreateTime(Date conCreateTime) {
        this.conCreateTime = conCreateTime;
    }

    public Date getConUpdateTime() {
        return conUpdateTime;
    }

    public void setConUpdateTime(Date conUpdateTime) {
        this.conUpdateTime = conUpdateTime;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", conId=").append(conId);
        sb.append(", conName=").append(conName);
        sb.append(", conTel=").append(conTel);
        sb.append(", conQq=").append(conQq);
        sb.append(", conWechat=").append(conWechat);
        sb.append(", conEmail=").append(conEmail);
        sb.append(", cusId=").append(cusId);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", conCreateTime=").append(conCreateTime);
        sb.append(", conUpdateTime=").append(conUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       /* List<SysRole> roles = this.getRoles();*/
        //Collection<SimpleGrantedAuthority> authorities=new HashSet<>();
        /*for (SysRole role : roles) {
            List<SysMenu> menus = role.getMenus();
            for (SysMenu menu : menus) {
                if(menu.getMenuPrmission()!=null&&menu.getMenuPrmission().length()>0){
                    authorities.add(new SimpleGrantedAuthority(menu.getMenuPrmission().trim()));
                }
            }
        }*/
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return getConName();
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
}