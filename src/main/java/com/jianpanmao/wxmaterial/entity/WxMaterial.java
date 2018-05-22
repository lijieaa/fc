package com.jianpanmao.wxmaterial.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class WxMaterial implements Serializable {
    //
    private Integer materialId;

    //
    @NotNull(message = "materialMediaId不能为空！")
    private String materialMediaId;

    //
    @NotNull(message = "materialType不能为空！")
    private String materialType;

    //
    @NotNull(message = "materialName不能为空！")
    private String materialName;

    //
    @NotNull(message = "materialUpdateTime不能为空！")
    private Date materialUpdateTime;

    //
    private String materialUrl;

    //
    private String materialTitle;

    //
    private String materialAuthor;

    //
    private String materialContentSourceUrl;

    //
    private String materialThumbMediaId;

    //
    private Integer materialShowCoverPic;

    //
    private String materialThumbUrl;

    //
    private Integer materialNeedOpenComment;

    //
    private Integer materialOnlyFansCanComment;

    //
    private String materialDigest;

    //
    private String materialContent;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialMediaId() {
        return materialMediaId;
    }

    public void setMaterialMediaId(String materialMediaId) {
        this.materialMediaId = materialMediaId == null ? null : materialMediaId.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public Date getMaterialUpdateTime() {
        return materialUpdateTime;
    }

    public void setMaterialUpdateTime(Date materialUpdateTime) {
        this.materialUpdateTime = materialUpdateTime;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl == null ? null : materialUrl.trim();
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle == null ? null : materialTitle.trim();
    }

    public String getMaterialAuthor() {
        return materialAuthor;
    }

    public void setMaterialAuthor(String materialAuthor) {
        this.materialAuthor = materialAuthor == null ? null : materialAuthor.trim();
    }

    public String getMaterialContentSourceUrl() {
        return materialContentSourceUrl;
    }

    public void setMaterialContentSourceUrl(String materialContentSourceUrl) {
        this.materialContentSourceUrl = materialContentSourceUrl == null ? null : materialContentSourceUrl.trim();
    }

    public String getMaterialThumbMediaId() {
        return materialThumbMediaId;
    }

    public void setMaterialThumbMediaId(String materialThumbMediaId) {
        this.materialThumbMediaId = materialThumbMediaId == null ? null : materialThumbMediaId.trim();
    }

    public Integer getMaterialShowCoverPic() {
        return materialShowCoverPic;
    }

    public void setMaterialShowCoverPic(Integer materialShowCoverPic) {
        this.materialShowCoverPic = materialShowCoverPic;
    }

    public String getMaterialThumbUrl() {
        return materialThumbUrl;
    }

    public void setMaterialThumbUrl(String materialThumbUrl) {
        this.materialThumbUrl = materialThumbUrl == null ? null : materialThumbUrl.trim();
    }

    public Integer getMaterialNeedOpenComment() {
        return materialNeedOpenComment;
    }

    public void setMaterialNeedOpenComment(Integer materialNeedOpenComment) {
        this.materialNeedOpenComment = materialNeedOpenComment;
    }

    public Integer getMaterialOnlyFansCanComment() {
        return materialOnlyFansCanComment;
    }

    public void setMaterialOnlyFansCanComment(Integer materialOnlyFansCanComment) {
        this.materialOnlyFansCanComment = materialOnlyFansCanComment;
    }

    public String getMaterialDigest() {
        return materialDigest;
    }

    public void setMaterialDigest(String materialDigest) {
        this.materialDigest = materialDigest == null ? null : materialDigest.trim();
    }

    public String getMaterialContent() {
        return materialContent;
    }

    public void setMaterialContent(String materialContent) {
        this.materialContent = materialContent == null ? null : materialContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", materialId=").append(materialId);
        sb.append(", materialMediaId=").append(materialMediaId);
        sb.append(", materialType=").append(materialType);
        sb.append(", materialName=").append(materialName);
        sb.append(", materialUpdateTime=").append(materialUpdateTime);
        sb.append(", materialUrl=").append(materialUrl);
        sb.append(", materialTitle=").append(materialTitle);
        sb.append(", materialAuthor=").append(materialAuthor);
        sb.append(", materialContentSourceUrl=").append(materialContentSourceUrl);
        sb.append(", materialThumbMediaId=").append(materialThumbMediaId);
        sb.append(", materialShowCoverPic=").append(materialShowCoverPic);
        sb.append(", materialThumbUrl=").append(materialThumbUrl);
        sb.append(", materialNeedOpenComment=").append(materialNeedOpenComment);
        sb.append(", materialOnlyFansCanComment=").append(materialOnlyFansCanComment);
        sb.append(", materialDigest=").append(materialDigest);
        sb.append(", materialContent=").append(materialContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}