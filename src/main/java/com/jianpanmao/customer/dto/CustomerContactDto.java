package com.jianpanmao.customer.dto;

import java.util.List;

/**
 * Created by mayn on 2018/7/22.
 */
public class CustomerContactDto {
    private Integer id;
    private String name;
    private String type;
    private Integer cusId;
    private List<CustomerContactDto> children;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public List<CustomerContactDto> getChildren() {
        return children;
    }

    public void setChildren(List<CustomerContactDto> children) {
        this.children = children;
    }
}
