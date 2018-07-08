package com.jianpanmao.sys.dto;

import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkUser;

import java.util.List;

/**
 * Created by mayn on 2018/7/8.
 * 部门人员树
 */
public class DeptUserDto {
    List<DingtalkDept> depts;
    List<DingtalkUser> users;

    public List<DingtalkDept> getDepts() {
        return depts;
    }

    public void setDepts(List<DingtalkDept> depts) {
        this.depts = depts;
    }

    public List<DingtalkUser> getUsers() {
        return users;
    }

    public void setUsers(List<DingtalkUser> users) {
        this.users = users;
    }
}
