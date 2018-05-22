package com.jianpanmao.wxmaterial.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxMaterialExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Integer value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Integer value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Integer value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Integer value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Integer> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Integer> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Integer value1, Integer value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdIsNull() {
            addCriterion("material_media_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdIsNotNull() {
            addCriterion("material_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdEqualTo(String value) {
            addCriterion("material_media_id =", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdNotEqualTo(String value) {
            addCriterion("material_media_id <>", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdGreaterThan(String value) {
            addCriterion("material_media_id >", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_media_id >=", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdLessThan(String value) {
            addCriterion("material_media_id <", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdLessThanOrEqualTo(String value) {
            addCriterion("material_media_id <=", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdLike(String value) {
            addCriterion("material_media_id like", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdNotLike(String value) {
            addCriterion("material_media_id not like", value, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdIn(List<String> values) {
            addCriterion("material_media_id in", values, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdNotIn(List<String> values) {
            addCriterion("material_media_id not in", values, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdBetween(String value1, String value2) {
            addCriterion("material_media_id between", value1, value2, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialMediaIdNotBetween(String value1, String value2) {
            addCriterion("material_media_id not between", value1, value2, "materialMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeIsNull() {
            addCriterion("material_update_time is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeIsNotNull() {
            addCriterion("material_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeEqualTo(Date value) {
            addCriterion("material_update_time =", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeNotEqualTo(Date value) {
            addCriterion("material_update_time <>", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeGreaterThan(Date value) {
            addCriterion("material_update_time >", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("material_update_time >=", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeLessThan(Date value) {
            addCriterion("material_update_time <", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("material_update_time <=", value, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeIn(List<Date> values) {
            addCriterion("material_update_time in", values, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeNotIn(List<Date> values) {
            addCriterion("material_update_time not in", values, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("material_update_time between", value1, value2, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("material_update_time not between", value1, value2, "materialUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIsNull() {
            addCriterion("material_url is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIsNotNull() {
            addCriterion("material_url is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlEqualTo(String value) {
            addCriterion("material_url =", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotEqualTo(String value) {
            addCriterion("material_url <>", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlGreaterThan(String value) {
            addCriterion("material_url >", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlGreaterThanOrEqualTo(String value) {
            addCriterion("material_url >=", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLessThan(String value) {
            addCriterion("material_url <", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLessThanOrEqualTo(String value) {
            addCriterion("material_url <=", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlLike(String value) {
            addCriterion("material_url like", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotLike(String value) {
            addCriterion("material_url not like", value, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlIn(List<String> values) {
            addCriterion("material_url in", values, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotIn(List<String> values) {
            addCriterion("material_url not in", values, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlBetween(String value1, String value2) {
            addCriterion("material_url between", value1, value2, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialUrlNotBetween(String value1, String value2) {
            addCriterion("material_url not between", value1, value2, "materialUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleIsNull() {
            addCriterion("material_title is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleIsNotNull() {
            addCriterion("material_title is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleEqualTo(String value) {
            addCriterion("material_title =", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleNotEqualTo(String value) {
            addCriterion("material_title <>", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleGreaterThan(String value) {
            addCriterion("material_title >", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleGreaterThanOrEqualTo(String value) {
            addCriterion("material_title >=", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleLessThan(String value) {
            addCriterion("material_title <", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleLessThanOrEqualTo(String value) {
            addCriterion("material_title <=", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleLike(String value) {
            addCriterion("material_title like", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleNotLike(String value) {
            addCriterion("material_title not like", value, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleIn(List<String> values) {
            addCriterion("material_title in", values, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleNotIn(List<String> values) {
            addCriterion("material_title not in", values, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleBetween(String value1, String value2) {
            addCriterion("material_title between", value1, value2, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialTitleNotBetween(String value1, String value2) {
            addCriterion("material_title not between", value1, value2, "materialTitle");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorIsNull() {
            addCriterion("material_author is null");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorIsNotNull() {
            addCriterion("material_author is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorEqualTo(String value) {
            addCriterion("material_author =", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorNotEqualTo(String value) {
            addCriterion("material_author <>", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorGreaterThan(String value) {
            addCriterion("material_author >", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("material_author >=", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorLessThan(String value) {
            addCriterion("material_author <", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorLessThanOrEqualTo(String value) {
            addCriterion("material_author <=", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorLike(String value) {
            addCriterion("material_author like", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorNotLike(String value) {
            addCriterion("material_author not like", value, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorIn(List<String> values) {
            addCriterion("material_author in", values, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorNotIn(List<String> values) {
            addCriterion("material_author not in", values, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorBetween(String value1, String value2) {
            addCriterion("material_author between", value1, value2, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialAuthorNotBetween(String value1, String value2) {
            addCriterion("material_author not between", value1, value2, "materialAuthor");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlIsNull() {
            addCriterion("material_content_source_url is null");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlIsNotNull() {
            addCriterion("material_content_source_url is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlEqualTo(String value) {
            addCriterion("material_content_source_url =", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlNotEqualTo(String value) {
            addCriterion("material_content_source_url <>", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlGreaterThan(String value) {
            addCriterion("material_content_source_url >", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("material_content_source_url >=", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlLessThan(String value) {
            addCriterion("material_content_source_url <", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("material_content_source_url <=", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlLike(String value) {
            addCriterion("material_content_source_url like", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlNotLike(String value) {
            addCriterion("material_content_source_url not like", value, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlIn(List<String> values) {
            addCriterion("material_content_source_url in", values, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlNotIn(List<String> values) {
            addCriterion("material_content_source_url not in", values, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlBetween(String value1, String value2) {
            addCriterion("material_content_source_url between", value1, value2, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialContentSourceUrlNotBetween(String value1, String value2) {
            addCriterion("material_content_source_url not between", value1, value2, "materialContentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdIsNull() {
            addCriterion("material_thumb_media_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdIsNotNull() {
            addCriterion("material_thumb_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdEqualTo(String value) {
            addCriterion("material_thumb_media_id =", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdNotEqualTo(String value) {
            addCriterion("material_thumb_media_id <>", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdGreaterThan(String value) {
            addCriterion("material_thumb_media_id >", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_thumb_media_id >=", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdLessThan(String value) {
            addCriterion("material_thumb_media_id <", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdLessThanOrEqualTo(String value) {
            addCriterion("material_thumb_media_id <=", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdLike(String value) {
            addCriterion("material_thumb_media_id like", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdNotLike(String value) {
            addCriterion("material_thumb_media_id not like", value, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdIn(List<String> values) {
            addCriterion("material_thumb_media_id in", values, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdNotIn(List<String> values) {
            addCriterion("material_thumb_media_id not in", values, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdBetween(String value1, String value2) {
            addCriterion("material_thumb_media_id between", value1, value2, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbMediaIdNotBetween(String value1, String value2) {
            addCriterion("material_thumb_media_id not between", value1, value2, "materialThumbMediaId");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicIsNull() {
            addCriterion("material_show_cover_pic is null");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicIsNotNull() {
            addCriterion("material_show_cover_pic is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicEqualTo(Integer value) {
            addCriterion("material_show_cover_pic =", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicNotEqualTo(Integer value) {
            addCriterion("material_show_cover_pic <>", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicGreaterThan(Integer value) {
            addCriterion("material_show_cover_pic >", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_show_cover_pic >=", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicLessThan(Integer value) {
            addCriterion("material_show_cover_pic <", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicLessThanOrEqualTo(Integer value) {
            addCriterion("material_show_cover_pic <=", value, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicIn(List<Integer> values) {
            addCriterion("material_show_cover_pic in", values, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicNotIn(List<Integer> values) {
            addCriterion("material_show_cover_pic not in", values, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicBetween(Integer value1, Integer value2) {
            addCriterion("material_show_cover_pic between", value1, value2, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialShowCoverPicNotBetween(Integer value1, Integer value2) {
            addCriterion("material_show_cover_pic not between", value1, value2, "materialShowCoverPic");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlIsNull() {
            addCriterion("material_thumb_url is null");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlIsNotNull() {
            addCriterion("material_thumb_url is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlEqualTo(String value) {
            addCriterion("material_thumb_url =", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlNotEqualTo(String value) {
            addCriterion("material_thumb_url <>", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlGreaterThan(String value) {
            addCriterion("material_thumb_url >", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlGreaterThanOrEqualTo(String value) {
            addCriterion("material_thumb_url >=", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlLessThan(String value) {
            addCriterion("material_thumb_url <", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlLessThanOrEqualTo(String value) {
            addCriterion("material_thumb_url <=", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlLike(String value) {
            addCriterion("material_thumb_url like", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlNotLike(String value) {
            addCriterion("material_thumb_url not like", value, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlIn(List<String> values) {
            addCriterion("material_thumb_url in", values, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlNotIn(List<String> values) {
            addCriterion("material_thumb_url not in", values, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlBetween(String value1, String value2) {
            addCriterion("material_thumb_url between", value1, value2, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialThumbUrlNotBetween(String value1, String value2) {
            addCriterion("material_thumb_url not between", value1, value2, "materialThumbUrl");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentIsNull() {
            addCriterion("material_need_open_comment is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentIsNotNull() {
            addCriterion("material_need_open_comment is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentEqualTo(Integer value) {
            addCriterion("material_need_open_comment =", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentNotEqualTo(Integer value) {
            addCriterion("material_need_open_comment <>", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentGreaterThan(Integer value) {
            addCriterion("material_need_open_comment >", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_need_open_comment >=", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentLessThan(Integer value) {
            addCriterion("material_need_open_comment <", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentLessThanOrEqualTo(Integer value) {
            addCriterion("material_need_open_comment <=", value, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentIn(List<Integer> values) {
            addCriterion("material_need_open_comment in", values, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentNotIn(List<Integer> values) {
            addCriterion("material_need_open_comment not in", values, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentBetween(Integer value1, Integer value2) {
            addCriterion("material_need_open_comment between", value1, value2, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialNeedOpenCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("material_need_open_comment not between", value1, value2, "materialNeedOpenComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentIsNull() {
            addCriterion("material_only_fans_can_comment is null");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentIsNotNull() {
            addCriterion("material_only_fans_can_comment is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentEqualTo(Integer value) {
            addCriterion("material_only_fans_can_comment =", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentNotEqualTo(Integer value) {
            addCriterion("material_only_fans_can_comment <>", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentGreaterThan(Integer value) {
            addCriterion("material_only_fans_can_comment >", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_only_fans_can_comment >=", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentLessThan(Integer value) {
            addCriterion("material_only_fans_can_comment <", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentLessThanOrEqualTo(Integer value) {
            addCriterion("material_only_fans_can_comment <=", value, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentIn(List<Integer> values) {
            addCriterion("material_only_fans_can_comment in", values, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentNotIn(List<Integer> values) {
            addCriterion("material_only_fans_can_comment not in", values, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentBetween(Integer value1, Integer value2) {
            addCriterion("material_only_fans_can_comment between", value1, value2, "materialOnlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andMaterialOnlyFansCanCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("material_only_fans_can_comment not between", value1, value2, "materialOnlyFansCanComment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}