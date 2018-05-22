package com.jianpanmao.wxuserdetail.entity;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class WxUserDetail implements Serializable {
    //
    private Integer wxUserDetailId;

    //是否订阅了该公众号,0已订阅，否则未订阅
    @NotNull(message = "subscribe不能为空！")
    private Byte subscribe;

    //openid
    @NotNull(message = "openid不能为空！")
    private String openid;

    //用户的昵称
    @NotNull(message = "nickname不能为空！")
    private String nickname;

    //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    @NotNull(message = "sex不能为空！")
    private Byte sex;

    //用户所在城市
    @NotNull(message = "city不能为空！")
    private String city;

    //用户所在国家
    @NotNull(message = "country不能为空！")
    private String country;

    //用户所在省份
    @NotNull(message = "province不能为空！")
    private String province;

    //用户的语言，简体中文为zh_CN
    @NotNull(message = "language不能为空！")
    private String language;

    //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
    private String headimgurl;

    //用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    @NotNull(message = "subscribeTime不能为空！")
    private Long subscribeTime;

    //只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
    private String unionid;

    //公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    private String remark;

    //用户所在的分组ID（兼容旧的用户分组接口）
    private Integer groupid;

    //返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
    private String subscribeScene;

    //所属公众号
    @NotNull(message = "publicId不能为空！")
    private Integer publicId;

    //所属公司
    @NotNull(message = "intermediaryId不能为空！")
    private Integer intermediaryId;

    private static final long serialVersionUID = 1L;

    String od;

    public Integer getWxUserDetailId() {
        return wxUserDetailId;
    }

    public void setWxUserDetailId(Integer wxUserDetailId) {
        this.wxUserDetailId = wxUserDetailId;
    }

    public Byte getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene == null ? null : subscribeScene.trim();
    }

    public Integer getPublicId() {
        return publicId;
    }

    public void setPublicId(Integer publicId) {
        this.publicId = publicId;
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
        sb.append(", wxUserDetailId=").append(wxUserDetailId);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", language=").append(language);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", subscribeTime=").append(subscribeTime);
        sb.append(", unionid=").append(unionid);
        sb.append(", remark=").append(remark);
        sb.append(", groupid=").append(groupid);
        sb.append(", subscribeScene=").append(subscribeScene);
        sb.append(", publicId=").append(publicId);
        sb.append(", intermediaryId=").append(intermediaryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}