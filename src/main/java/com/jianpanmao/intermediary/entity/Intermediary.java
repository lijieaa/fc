package com.jianpanmao.intermediary.entity;

import com.jianpanmao.area.entity.Area;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Intermediary implements Serializable {
    //
    private Integer intermediaryId;

    //中间商名称
    @NotBlank(message = "名称不能为空")
    @Size(min = 1, max = 64, message = "名称字数在1-64之间")
    private String intermediaryName;

    //中间商联系人
    @NotBlank(message = "联系人不能为空")
    @Size(min = 1, max = 16, message = "联系人字数在1-16之间")
    private String intermediaryContact;

    //中间商联系方式
    @NotBlank(message = "中间商联系方式不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "请输入正确电话号码")
    private String intermediaryContactTel;

    //所属地区
    private @NotNull(message = "所属地区不能为空") Area area;

    //平台对接人
    private @NotNull(message = "平台对接人不能为空") DingtalkUser user;

    //平台LOGO
    @NotNull(message = "logo不能为空")
    @Size(min = 1, max = 256, message = "logo在1-256之间")
    private String intermediaryLogoUrl;

    //创建时间
    private Date intermediaryCreateTime;

    //更新时间
    private Date intermediaryUpdateTime;

    //
    @NotNull(message = "中间商所属不能为空")
    private Integer isPlat;

    //图文简介
    @NotBlank(message = "图文简介不能为空")
    private String intermediaryIntroduction;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(Integer intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public String getIntermediaryName() {
        return intermediaryName;
    }

    public void setIntermediaryName(String intermediaryName) {
        this.intermediaryName = intermediaryName == null ? null : intermediaryName.trim();
    }

    public String getIntermediaryContact() {
        return intermediaryContact;
    }

    public void setIntermediaryContact(String intermediaryContact) {
        this.intermediaryContact = intermediaryContact == null ? null : intermediaryContact.trim();
    }

    public String getIntermediaryContactTel() {
        return intermediaryContactTel;
    }

    public void setIntermediaryContactTel(String intermediaryContactTel) {
        this.intermediaryContactTel = intermediaryContactTel == null ? null : intermediaryContactTel.trim();
    }



    public String getIntermediaryLogoUrl() {
        return intermediaryLogoUrl;
    }

    public void setIntermediaryLogoUrl(String intermediaryLogoUrl) {
        this.intermediaryLogoUrl = intermediaryLogoUrl == null ? null : intermediaryLogoUrl.trim();
    }

    public Date getIntermediaryCreateTime() {
        return intermediaryCreateTime;
    }

    public void setIntermediaryCreateTime(Date intermediaryCreateTime) {
        this.intermediaryCreateTime = intermediaryCreateTime;
    }

    public Date getIntermediaryUpdateTime() {
        return intermediaryUpdateTime;
    }

    public void setIntermediaryUpdateTime(Date intermediaryUpdateTime) {
        this.intermediaryUpdateTime = intermediaryUpdateTime;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public DingtalkUser getUser() {
        return user;
    }

    public void setUser(DingtalkUser user) {
        this.user = user;
    }

    public Integer getIsPlat() {
        return isPlat;
    }

    public void setIsPlat(Integer isPlat) {
        this.isPlat = isPlat;
    }

    public String getIntermediaryIntroduction() {
        return intermediaryIntroduction;
    }

    public void setIntermediaryIntroduction(String intermediaryIntroduction) {
        this.intermediaryIntroduction = intermediaryIntroduction == null ? null : intermediaryIntroduction.trim();
    }

}