package com.jianpanmao.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class DingtalkDept implements Serializable {
    //部门ID
    private Integer id;

    //
    @NotNull(message = "部门名称不能为空！")
    private String name;

    //

    private Integer parentid;

    //在父部门中的次序值。order值小的排序靠前
    private Integer order;

    //是否创建一个关联此部门的企业群，默认为false
    private Boolean createdeptgroup;

    //是否隐藏部门, true表示隐藏, false表示显示
    private Boolean depthiding;

    //可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用 | 符号进行分割。总数不能超过200。
    private String deptperimits;

    //可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用| 符号进行分割。总数不能超过200。
    private String userperimits;

    //是否本部门的员工仅可见员工自己, 为true时，本部门员工默认只能看到员工自己
    private Boolean outerdept;

    //本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用|符号进行分割。总数不能超过200。
    private String outerpermitusers;

    //部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
    private String sourceidentifier;

    //中间商ID，标识这个部门属于哪个中间商
    private Integer intermediaryId;

    //
    private Date createTime;

    //
    private Date updateTime;

    //
    private String path;

    private static final long serialVersionUID = 1L;

    String od;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
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
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}