package com.jianpanmao.intermediary.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntermediaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntermediaryExample() {
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

        public Criteria andIntermediaryNameIsNull() {
            addCriterion("intermediary_name is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameIsNotNull() {
            addCriterion("intermediary_name is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameEqualTo(String value) {
            addCriterion("intermediary_name =", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameNotEqualTo(String value) {
            addCriterion("intermediary_name <>", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameGreaterThan(String value) {
            addCriterion("intermediary_name >", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("intermediary_name >=", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameLessThan(String value) {
            addCriterion("intermediary_name <", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameLessThanOrEqualTo(String value) {
            addCriterion("intermediary_name <=", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameLike(String value) {
            addCriterion("intermediary_name like", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameNotLike(String value) {
            addCriterion("intermediary_name not like", value, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameIn(List<String> values) {
            addCriterion("intermediary_name in", values, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameNotIn(List<String> values) {
            addCriterion("intermediary_name not in", values, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameBetween(String value1, String value2) {
            addCriterion("intermediary_name between", value1, value2, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryNameNotBetween(String value1, String value2) {
            addCriterion("intermediary_name not between", value1, value2, "intermediaryName");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactIsNull() {
            addCriterion("intermediary_contact is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactIsNotNull() {
            addCriterion("intermediary_contact is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactEqualTo(String value) {
            addCriterion("intermediary_contact =", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactNotEqualTo(String value) {
            addCriterion("intermediary_contact <>", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactGreaterThan(String value) {
            addCriterion("intermediary_contact >", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactGreaterThanOrEqualTo(String value) {
            addCriterion("intermediary_contact >=", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactLessThan(String value) {
            addCriterion("intermediary_contact <", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactLessThanOrEqualTo(String value) {
            addCriterion("intermediary_contact <=", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactLike(String value) {
            addCriterion("intermediary_contact like", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactNotLike(String value) {
            addCriterion("intermediary_contact not like", value, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactIn(List<String> values) {
            addCriterion("intermediary_contact in", values, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactNotIn(List<String> values) {
            addCriterion("intermediary_contact not in", values, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactBetween(String value1, String value2) {
            addCriterion("intermediary_contact between", value1, value2, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactNotBetween(String value1, String value2) {
            addCriterion("intermediary_contact not between", value1, value2, "intermediaryContact");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelIsNull() {
            addCriterion("intermediary_contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelIsNotNull() {
            addCriterion("intermediary_contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelEqualTo(String value) {
            addCriterion("intermediary_contact_tel =", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelNotEqualTo(String value) {
            addCriterion("intermediary_contact_tel <>", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelGreaterThan(String value) {
            addCriterion("intermediary_contact_tel >", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("intermediary_contact_tel >=", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelLessThan(String value) {
            addCriterion("intermediary_contact_tel <", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelLessThanOrEqualTo(String value) {
            addCriterion("intermediary_contact_tel <=", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelLike(String value) {
            addCriterion("intermediary_contact_tel like", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelNotLike(String value) {
            addCriterion("intermediary_contact_tel not like", value, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelIn(List<String> values) {
            addCriterion("intermediary_contact_tel in", values, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelNotIn(List<String> values) {
            addCriterion("intermediary_contact_tel not in", values, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelBetween(String value1, String value2) {
            addCriterion("intermediary_contact_tel between", value1, value2, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andIntermediaryContactTelNotBetween(String value1, String value2) {
            addCriterion("intermediary_contact_tel not between", value1, value2, "intermediaryContactTel");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlIsNull() {
            addCriterion("intermediary_logo_url is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlIsNotNull() {
            addCriterion("intermediary_logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlEqualTo(String value) {
            addCriterion("intermediary_logo_url =", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlNotEqualTo(String value) {
            addCriterion("intermediary_logo_url <>", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlGreaterThan(String value) {
            addCriterion("intermediary_logo_url >", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("intermediary_logo_url >=", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlLessThan(String value) {
            addCriterion("intermediary_logo_url <", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("intermediary_logo_url <=", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlLike(String value) {
            addCriterion("intermediary_logo_url like", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlNotLike(String value) {
            addCriterion("intermediary_logo_url not like", value, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlIn(List<String> values) {
            addCriterion("intermediary_logo_url in", values, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlNotIn(List<String> values) {
            addCriterion("intermediary_logo_url not in", values, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlBetween(String value1, String value2) {
            addCriterion("intermediary_logo_url between", value1, value2, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryLogoUrlNotBetween(String value1, String value2) {
            addCriterion("intermediary_logo_url not between", value1, value2, "intermediaryLogoUrl");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeIsNull() {
            addCriterion("intermediary_create_time is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeIsNotNull() {
            addCriterion("intermediary_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeEqualTo(Date value) {
            addCriterion("intermediary_create_time =", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeNotEqualTo(Date value) {
            addCriterion("intermediary_create_time <>", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeGreaterThan(Date value) {
            addCriterion("intermediary_create_time >", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("intermediary_create_time >=", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeLessThan(Date value) {
            addCriterion("intermediary_create_time <", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("intermediary_create_time <=", value, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeIn(List<Date> values) {
            addCriterion("intermediary_create_time in", values, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeNotIn(List<Date> values) {
            addCriterion("intermediary_create_time not in", values, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeBetween(Date value1, Date value2) {
            addCriterion("intermediary_create_time between", value1, value2, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("intermediary_create_time not between", value1, value2, "intermediaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeIsNull() {
            addCriterion("intermediary_update_time is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeIsNotNull() {
            addCriterion("intermediary_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeEqualTo(Date value) {
            addCriterion("intermediary_update_time =", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeNotEqualTo(Date value) {
            addCriterion("intermediary_update_time <>", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeGreaterThan(Date value) {
            addCriterion("intermediary_update_time >", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("intermediary_update_time >=", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeLessThan(Date value) {
            addCriterion("intermediary_update_time <", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("intermediary_update_time <=", value, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeIn(List<Date> values) {
            addCriterion("intermediary_update_time in", values, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeNotIn(List<Date> values) {
            addCriterion("intermediary_update_time not in", values, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("intermediary_update_time between", value1, value2, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIntermediaryUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("intermediary_update_time not between", value1, value2, "intermediaryUpdateTime");
            return (Criteria) this;
        }

        public Criteria andIsPlatIsNull() {
            addCriterion("is_plat is null");
            return (Criteria) this;
        }

        public Criteria andIsPlatIsNotNull() {
            addCriterion("is_plat is not null");
            return (Criteria) this;
        }

        public Criteria andIsPlatEqualTo(Integer value) {
            addCriterion("is_plat =", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatNotEqualTo(Integer value) {
            addCriterion("is_plat <>", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatGreaterThan(Integer value) {
            addCriterion("is_plat >", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_plat >=", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatLessThan(Integer value) {
            addCriterion("is_plat <", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatLessThanOrEqualTo(Integer value) {
            addCriterion("is_plat <=", value, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatIn(List<Integer> values) {
            addCriterion("is_plat in", values, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatNotIn(List<Integer> values) {
            addCriterion("is_plat not in", values, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatBetween(Integer value1, Integer value2) {
            addCriterion("is_plat between", value1, value2, "isPlat");
            return (Criteria) this;
        }

        public Criteria andIsPlatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_plat not between", value1, value2, "isPlat");
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