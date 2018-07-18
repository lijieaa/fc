package com.jianpanmao.sys.dto;

import java.util.List;

/**
 * Created by mayn on 2018/7/8.
 * 部门人员树
 */
public class DeptUserDto {
   private Integer id;
    private String name;
    private Integer parentId;
    private List<DeptUserDto> children;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<DeptUserDto> getChildren() {
        return children;
    }

    public void setChildren(List<DeptUserDto> children) {
        this.children = children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
