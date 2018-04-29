package com.we.fc.dept.entity;

import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.DingtalkUser;

import java.util.List;


/**
 * 部门
 * @author zdc
 * @since 2018-03-27 21:50
 */
public class Dept extends BaseEntity {

    // 部门名称
    private String name;

    // 部门成员
    private List<DingtalkUser> users;

    // 排序
    private Integer sortd;

    private Dept parent;

    private List<Dept> children;

    // 员工数
    private int userCount;

    public List<Dept> getChildren() {
        return children;
    }

    public void setChildren(List<Dept> children) {
        this.children = children;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DingtalkUser> getUsers() {
        return users;
    }

    public void setUsers(List<DingtalkUser> users) {
        this.users = users;
    }

    public Integer getSortd() {
        return sortd;
    }

    public void setSortd(Integer sortd) {
        this.sortd = sortd;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
