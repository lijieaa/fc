package com.we.fc.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.we.fc.base.BaseEntity;
import com.we.fc.company.entity.Company;
import com.we.fc.dept.entity.Dept;
import com.we.fc.menu.entity.Menu;
import com.we.fc.role.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * 用户
 * @author zdc
 * @since 2018-03-26 23:18
 */

public class User extends BaseEntity implements UserDetails{

    // 登录名
    private String username;
    // 登录密码
    private String password;
    // 真实姓名
    private String realName;
    // 所属部门
    private Dept dept;
    // 角色
    private List<Role> roles;
    // 联系电话
    private String telephone;
    // 职位
    private String position;
    // 工号
    private String jobNumber;
    // 邮箱
    private String email;
    // 工作地点
    private String workAddress;
    // 入职时间
    private Date entryTime;

    private Set<Menu> menus;

    private Integer admin;

    private Integer platformAdmin;

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getPlatformAdmin() {
        return platformAdmin;
    }

    public void setPlatformAdmin(Integer platformAdmin) {
        this.platformAdmin = platformAdmin;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> collection = new ArrayList<>();
        for(Role role : roles){
            collection.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return collection;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

}
