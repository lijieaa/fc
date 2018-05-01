package com.we.fc.dept.entity;

import com.we.fc.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class DingtalkDept extends BaseEntity {

    private String name;

    private Integer parentid;

    private Integer order;

    private Boolean createdeptgroup;

    private Boolean depthiding;

    private String deptperimits;

    private String userperimits;

    private Boolean outerdept;

    private String outerpermitusers;

    private String sourceidentifier;

    private Integer intermediaryId;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;



    private static final long serialVersionUID = 1L;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getCreatedeptgroup() {
        return createdeptgroup;
    }

    public void setCreatedeptgroup(Boolean createdeptgroup) {
        this.createdeptgroup = createdeptgroup;
    }

    public Boolean getDepthiding() {
        return depthiding;
    }

    public void setDepthiding(Boolean depthiding) {
        this.depthiding = depthiding;
    }

    public String getDeptperimits() {
        return deptperimits;
    }

    public void setDeptperimits(String deptperimits) {
        this.deptperimits = deptperimits == null ? null : deptperimits.trim();
    }

    public String getUserperimits() {
        return userperimits;
    }

    public void setUserperimits(String userperimits) {
        this.userperimits = userperimits == null ? null : userperimits.trim();
    }

    public Boolean getOuterdept() {
        return outerdept;
    }

    public void setOuterdept(Boolean outerdept) {
        this.outerdept = outerdept;
    }

    public String getOuterpermitusers() {
        return outerpermitusers;
    }

    public void setOuterpermitusers(String outerpermitusers) {
        this.outerpermitusers = outerpermitusers == null ? null : outerpermitusers.trim();
    }

    public String getSourceidentifier() {
        return sourceidentifier;
    }

    public void setSourceidentifier(String sourceidentifier) {
        this.sourceidentifier = sourceidentifier == null ? null : sourceidentifier.trim();
    }

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(this.getId());
        sb.append(", name=").append(name);
        sb.append(", parentid=").append(parentid);
        sb.append(", order=").append(order);
        sb.append(", createdeptgroup=").append(createdeptgroup);
        sb.append(", depthiding=").append(depthiding);
        sb.append(", deptperimits=").append(deptperimits);
        sb.append(", userperimits=").append(userperimits);
        sb.append(", outerdept=").append(outerdept);
        sb.append(", outerpermitusers=").append(outerpermitusers);
        sb.append(", sourceidentifier=").append(sourceidentifier);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", createTime=").append(this.getCreateTime());
        sb.append(", updateTime=").append(this.getUpdateTime());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}