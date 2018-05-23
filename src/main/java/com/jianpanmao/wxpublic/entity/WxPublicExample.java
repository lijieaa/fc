package com.jianpanmao.wxpublic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxPublicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxPublicExample() {
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

        public Criteria andPublicIdIsNull() {
            addCriterion("public_id is null");
            return (Criteria) this;
        }

        public Criteria andPublicIdIsNotNull() {
            addCriterion("public_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublicIdEqualTo(Integer value) {
            addCriterion("public_id =", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdNotEqualTo(Integer value) {
            addCriterion("public_id <>", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdGreaterThan(Integer value) {
            addCriterion("public_id >", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("public_id >=", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdLessThan(Integer value) {
            addCriterion("public_id <", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdLessThanOrEqualTo(Integer value) {
            addCriterion("public_id <=", value, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdIn(List<Integer> values) {
            addCriterion("public_id in", values, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdNotIn(List<Integer> values) {
            addCriterion("public_id not in", values, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdBetween(Integer value1, Integer value2) {
            addCriterion("public_id between", value1, value2, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("public_id not between", value1, value2, "publicId");
            return (Criteria) this;
        }

        public Criteria andPublicNameIsNull() {
            addCriterion("public_name is null");
            return (Criteria) this;
        }

        public Criteria andPublicNameIsNotNull() {
            addCriterion("public_name is not null");
            return (Criteria) this;
        }

        public Criteria andPublicNameEqualTo(String value) {
            addCriterion("public_name =", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameNotEqualTo(String value) {
            addCriterion("public_name <>", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameGreaterThan(String value) {
            addCriterion("public_name >", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameGreaterThanOrEqualTo(String value) {
            addCriterion("public_name >=", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameLessThan(String value) {
            addCriterion("public_name <", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameLessThanOrEqualTo(String value) {
            addCriterion("public_name <=", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameLike(String value) {
            addCriterion("public_name like", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameNotLike(String value) {
            addCriterion("public_name not like", value, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameIn(List<String> values) {
            addCriterion("public_name in", values, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameNotIn(List<String> values) {
            addCriterion("public_name not in", values, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameBetween(String value1, String value2) {
            addCriterion("public_name between", value1, value2, "publicName");
            return (Criteria) this;
        }

        public Criteria andPublicNameNotBetween(String value1, String value2) {
            addCriterion("public_name not between", value1, value2, "publicName");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andPublicEmailIsNull() {
            addCriterion("public_email is null");
            return (Criteria) this;
        }

        public Criteria andPublicEmailIsNotNull() {
            addCriterion("public_email is not null");
            return (Criteria) this;
        }

        public Criteria andPublicEmailEqualTo(String value) {
            addCriterion("public_email =", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailNotEqualTo(String value) {
            addCriterion("public_email <>", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailGreaterThan(String value) {
            addCriterion("public_email >", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailGreaterThanOrEqualTo(String value) {
            addCriterion("public_email >=", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailLessThan(String value) {
            addCriterion("public_email <", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailLessThanOrEqualTo(String value) {
            addCriterion("public_email <=", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailLike(String value) {
            addCriterion("public_email like", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailNotLike(String value) {
            addCriterion("public_email not like", value, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailIn(List<String> values) {
            addCriterion("public_email in", values, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailNotIn(List<String> values) {
            addCriterion("public_email not in", values, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailBetween(String value1, String value2) {
            addCriterion("public_email between", value1, value2, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andPublicEmailNotBetween(String value1, String value2) {
            addCriterion("public_email not between", value1, value2, "publicEmail");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdIsNull() {
            addCriterion("intermediary_id is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdIsNotNull() {
            addCriterion("intermediary_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdEqualTo(Integer value) {
            addCriterion("intermediary_id =", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdNotEqualTo(Integer value) {
            addCriterion("intermediary_id <>", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdGreaterThan(Integer value) {
            addCriterion("intermediary_id >", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("intermediary_id >=", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdLessThan(Integer value) {
            addCriterion("intermediary_id <", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdLessThanOrEqualTo(Integer value) {
            addCriterion("intermediary_id <=", value, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdIn(List<Integer> values) {
            addCriterion("intermediary_id in", values, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdNotIn(List<Integer> values) {
            addCriterion("intermediary_id not in", values, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdBetween(Integer value1, Integer value2) {
            addCriterion("intermediary_id between", value1, value2, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("intermediary_id not between", value1, value2, "intermediaryId");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeIsNull() {
            addCriterion("wx_public_create_time is null");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeIsNotNull() {
            addCriterion("wx_public_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeEqualTo(Date value) {
            addCriterion("wx_public_create_time =", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeNotEqualTo(Date value) {
            addCriterion("wx_public_create_time <>", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeGreaterThan(Date value) {
            addCriterion("wx_public_create_time >", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_public_create_time >=", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeLessThan(Date value) {
            addCriterion("wx_public_create_time <", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("wx_public_create_time <=", value, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeIn(List<Date> values) {
            addCriterion("wx_public_create_time in", values, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeNotIn(List<Date> values) {
            addCriterion("wx_public_create_time not in", values, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeBetween(Date value1, Date value2) {
            addCriterion("wx_public_create_time between", value1, value2, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("wx_public_create_time not between", value1, value2, "wxPublicCreateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeIsNull() {
            addCriterion("wx_public_update_time is null");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeIsNotNull() {
            addCriterion("wx_public_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeEqualTo(Date value) {
            addCriterion("wx_public_update_time =", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeNotEqualTo(Date value) {
            addCriterion("wx_public_update_time <>", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeGreaterThan(Date value) {
            addCriterion("wx_public_update_time >", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_public_update_time >=", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeLessThan(Date value) {
            addCriterion("wx_public_update_time <", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("wx_public_update_time <=", value, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeIn(List<Date> values) {
            addCriterion("wx_public_update_time in", values, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeNotIn(List<Date> values) {
            addCriterion("wx_public_update_time not in", values, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("wx_public_update_time between", value1, value2, "wxPublicUpdateTime");
            return (Criteria) this;
        }

        public Criteria andWxPublicUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("wx_public_update_time not between", value1, value2, "wxPublicUpdateTime");
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