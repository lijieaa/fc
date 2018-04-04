package com.we.fc.company.entity;


import com.we.fc.base.BaseEntity;
import com.we.fc.dept.entity.Dept;

import java.util.List;

/**
 * 公司
 * @author zdc
 * @since 2018-03-27 22:25
 */
public class Company extends BaseEntity {

    // 公司名称
    private String name;
    // 部门列表
    private List<Dept> depts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }
}
