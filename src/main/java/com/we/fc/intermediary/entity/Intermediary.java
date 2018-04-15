package com.we.fc.intermediary.entity;

import com.we.fc.area.entity.Area;
import com.we.fc.base.BaseEntity;
import com.we.fc.user.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 中间商
 */
public class Intermediary extends BaseEntity implements Serializable {


    private int isPlat;//是否为fc平台（否0 是1）

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.intermediary_name
     *
     * @mbggenerated
     */
    private String intermediaryName;   //中间商名称

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.intermediary_contact
     *
     * @mbggenerated
     */
    private String intermediaryContact;  //中间商联系人

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.intermediary_contact_tel
     *
     * @mbggenerated
     */
    private String intermediaryContactTel;//中间商联系方式

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.area_id
     *
     * @mbggenerated
     */
    private Area area;//所属地区

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.user_id
     *
     * @mbggenerated
     */
    private User user;//平台对接人

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.intermediary_logo_url
     *
     * @mbggenerated
     */
    private String intermediaryLogoUrl; //logo url

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column intermediary.intermediary_introduction
     *
     * @mbggenerated
     */
    private String intermediaryIntroduction; //图文简介


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table intermediary
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_id
     *
     * @return the value of intermediary.intermediary_id
     *
     * @mbggenerated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_name
     *
     * @return the value of intermediary.intermediary_name
     *
     * @mbggenerated
     */
    public String getIntermediaryName() {
        return intermediaryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intermediary.intermediary_name
     *
     * @param intermediaryName the value for intermediary.intermediary_name
     *
     * @mbggenerated
     */
    public void setIntermediaryName(String intermediaryName) {
        this.intermediaryName = intermediaryName == null ? null : intermediaryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_contact
     *
     * @return the value of intermediary.intermediary_contact
     *
     * @mbggenerated
     */
    public String getIntermediaryContact() {
        return intermediaryContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intermediary.intermediary_contact
     *
     * @param intermediaryContact the value for intermediary.intermediary_contact
     *
     * @mbggenerated
     */
    public void setIntermediaryContact(String intermediaryContact) {
        this.intermediaryContact = intermediaryContact == null ? null : intermediaryContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_contact_tel
     *
     * @return the value of intermediary.intermediary_contact_tel
     *
     * @mbggenerated
     */
    public String getIntermediaryContactTel() {
        return intermediaryContactTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intermediary.intermediary_contact_tel
     *
     * @param intermediaryContactTel the value for intermediary.intermediary_contact_tel
     *
     * @mbggenerated
     */
    public void setIntermediaryContactTel(String intermediaryContactTel) {
        this.intermediaryContactTel = intermediaryContactTel == null ? null : intermediaryContactTel.trim();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_logo_url
     *
     * @return the value of intermediary.intermediary_logo_url
     *
     * @mbggenerated
     */
    public String getIntermediaryLogoUrl() {
        return intermediaryLogoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intermediary.intermediary_logo_url
     *
     * @param intermediaryLogoUrl the value for intermediary.intermediary_logo_url
     *
     * @mbggenerated
     */
    public void setIntermediaryLogoUrl(String intermediaryLogoUrl) {
        this.intermediaryLogoUrl = intermediaryLogoUrl == null ? null : intermediaryLogoUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column intermediary.intermediary_introduction
     *
     * @return the value of intermediary.intermediary_introduction
     *
     * @mbggenerated
     */
    public String getIntermediaryIntroduction() {
        return intermediaryIntroduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column intermediary.intermediary_introduction
     *
     * @param intermediaryIntroduction the value for intermediary.intermediary_introduction
     *
     * @mbggenerated
     */
    public void setIntermediaryIntroduction(String intermediaryIntroduction) {
        this.intermediaryIntroduction = intermediaryIntroduction == null ? null : intermediaryIntroduction.trim();
    }

    public int getIsPlat() {
        return isPlat;
    }

    public void setIsPlat(int isPlat) {
        this.isPlat = isPlat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table intermediary
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", intermediaryName=").append(intermediaryName);
        sb.append(", intermediaryContact=").append(intermediaryContact);
        sb.append(", intermediaryContactTel=").append(intermediaryContactTel);
        sb.append(", areaId=").append(area);
        sb.append(", userId=").append(user);
        sb.append(", intermediaryLogoUrl=").append(intermediaryLogoUrl);
        sb.append(", intermediaryIntroduction=").append(intermediaryIntroduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}