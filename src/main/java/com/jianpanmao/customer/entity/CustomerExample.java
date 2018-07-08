package com.jianpanmao.customer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCusIdIsNull() {
            addCriterion("cus_id is null");
            return (Criteria) this;
        }

        public Criteria andCusIdIsNotNull() {
            addCriterion("cus_id is not null");
            return (Criteria) this;
        }

        public Criteria andCusIdEqualTo(Integer value) {
            addCriterion("cus_id =", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdNotEqualTo(Integer value) {
            addCriterion("cus_id <>", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdGreaterThan(Integer value) {
            addCriterion("cus_id >", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cus_id >=", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdLessThan(Integer value) {
            addCriterion("cus_id <", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdLessThanOrEqualTo(Integer value) {
            addCriterion("cus_id <=", value, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdIn(List<Integer> values) {
            addCriterion("cus_id in", values, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdNotIn(List<Integer> values) {
            addCriterion("cus_id not in", values, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdBetween(Integer value1, Integer value2) {
            addCriterion("cus_id between", value1, value2, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cus_id not between", value1, value2, "cusId");
            return (Criteria) this;
        }

        public Criteria andCusComNameIsNull() {
            addCriterion("cus_com_name is null");
            return (Criteria) this;
        }

        public Criteria andCusComNameIsNotNull() {
            addCriterion("cus_com_name is not null");
            return (Criteria) this;
        }

        public Criteria andCusComNameEqualTo(String value) {
            addCriterion("cus_com_name =", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameNotEqualTo(String value) {
            addCriterion("cus_com_name <>", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameGreaterThan(String value) {
            addCriterion("cus_com_name >", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameGreaterThanOrEqualTo(String value) {
            addCriterion("cus_com_name >=", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameLessThan(String value) {
            addCriterion("cus_com_name <", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameLessThanOrEqualTo(String value) {
            addCriterion("cus_com_name <=", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameLike(String value) {
            addCriterion("cus_com_name like", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameNotLike(String value) {
            addCriterion("cus_com_name not like", value, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameIn(List<String> values) {
            addCriterion("cus_com_name in", values, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameNotIn(List<String> values) {
            addCriterion("cus_com_name not in", values, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameBetween(String value1, String value2) {
            addCriterion("cus_com_name between", value1, value2, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComNameNotBetween(String value1, String value2) {
            addCriterion("cus_com_name not between", value1, value2, "cusComName");
            return (Criteria) this;
        }

        public Criteria andCusComTelIsNull() {
            addCriterion("cus_com_tel is null");
            return (Criteria) this;
        }

        public Criteria andCusComTelIsNotNull() {
            addCriterion("cus_com_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCusComTelEqualTo(String value) {
            addCriterion("cus_com_tel =", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelNotEqualTo(String value) {
            addCriterion("cus_com_tel <>", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelGreaterThan(String value) {
            addCriterion("cus_com_tel >", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelGreaterThanOrEqualTo(String value) {
            addCriterion("cus_com_tel >=", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelLessThan(String value) {
            addCriterion("cus_com_tel <", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelLessThanOrEqualTo(String value) {
            addCriterion("cus_com_tel <=", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelLike(String value) {
            addCriterion("cus_com_tel like", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelNotLike(String value) {
            addCriterion("cus_com_tel not like", value, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelIn(List<String> values) {
            addCriterion("cus_com_tel in", values, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelNotIn(List<String> values) {
            addCriterion("cus_com_tel not in", values, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelBetween(String value1, String value2) {
            addCriterion("cus_com_tel between", value1, value2, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComTelNotBetween(String value1, String value2) {
            addCriterion("cus_com_tel not between", value1, value2, "cusComTel");
            return (Criteria) this;
        }

        public Criteria andCusComEmailIsNull() {
            addCriterion("cus_com_email is null");
            return (Criteria) this;
        }

        public Criteria andCusComEmailIsNotNull() {
            addCriterion("cus_com_email is not null");
            return (Criteria) this;
        }

        public Criteria andCusComEmailEqualTo(String value) {
            addCriterion("cus_com_email =", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailNotEqualTo(String value) {
            addCriterion("cus_com_email <>", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailGreaterThan(String value) {
            addCriterion("cus_com_email >", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cus_com_email >=", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailLessThan(String value) {
            addCriterion("cus_com_email <", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailLessThanOrEqualTo(String value) {
            addCriterion("cus_com_email <=", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailLike(String value) {
            addCriterion("cus_com_email like", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailNotLike(String value) {
            addCriterion("cus_com_email not like", value, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailIn(List<String> values) {
            addCriterion("cus_com_email in", values, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailNotIn(List<String> values) {
            addCriterion("cus_com_email not in", values, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailBetween(String value1, String value2) {
            addCriterion("cus_com_email between", value1, value2, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComEmailNotBetween(String value1, String value2) {
            addCriterion("cus_com_email not between", value1, value2, "cusComEmail");
            return (Criteria) this;
        }

        public Criteria andCusComAdrIsNull() {
            addCriterion("cus_com_adr is null");
            return (Criteria) this;
        }

        public Criteria andCusComAdrIsNotNull() {
            addCriterion("cus_com_adr is not null");
            return (Criteria) this;
        }

        public Criteria andCusComAdrEqualTo(String value) {
            addCriterion("cus_com_adr =", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrNotEqualTo(String value) {
            addCriterion("cus_com_adr <>", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrGreaterThan(String value) {
            addCriterion("cus_com_adr >", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrGreaterThanOrEqualTo(String value) {
            addCriterion("cus_com_adr >=", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrLessThan(String value) {
            addCriterion("cus_com_adr <", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrLessThanOrEqualTo(String value) {
            addCriterion("cus_com_adr <=", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrLike(String value) {
            addCriterion("cus_com_adr like", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrNotLike(String value) {
            addCriterion("cus_com_adr not like", value, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrIn(List<String> values) {
            addCriterion("cus_com_adr in", values, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrNotIn(List<String> values) {
            addCriterion("cus_com_adr not in", values, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrBetween(String value1, String value2) {
            addCriterion("cus_com_adr between", value1, value2, "cusComAdr");
            return (Criteria) this;
        }

        public Criteria andCusComAdrNotBetween(String value1, String value2) {
            addCriterion("cus_com_adr not between", value1, value2, "cusComAdr");
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

        public Criteria andCusCreateTimeIsNull() {
            addCriterion("cus_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeIsNotNull() {
            addCriterion("cus_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeEqualTo(Date value) {
            addCriterion("cus_create_time =", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeNotEqualTo(Date value) {
            addCriterion("cus_create_time <>", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeGreaterThan(Date value) {
            addCriterion("cus_create_time >", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cus_create_time >=", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeLessThan(Date value) {
            addCriterion("cus_create_time <", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("cus_create_time <=", value, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeIn(List<Date> values) {
            addCriterion("cus_create_time in", values, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeNotIn(List<Date> values) {
            addCriterion("cus_create_time not in", values, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeBetween(Date value1, Date value2) {
            addCriterion("cus_create_time between", value1, value2, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("cus_create_time not between", value1, value2, "cusCreateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeIsNull() {
            addCriterion("cus_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeIsNotNull() {
            addCriterion("cus_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeEqualTo(Date value) {
            addCriterion("cus_update_time =", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeNotEqualTo(Date value) {
            addCriterion("cus_update_time <>", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeGreaterThan(Date value) {
            addCriterion("cus_update_time >", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cus_update_time >=", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeLessThan(Date value) {
            addCriterion("cus_update_time <", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("cus_update_time <=", value, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeIn(List<Date> values) {
            addCriterion("cus_update_time in", values, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeNotIn(List<Date> values) {
            addCriterion("cus_update_time not in", values, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("cus_update_time between", value1, value2, "cusUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCusUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("cus_update_time not between", value1, value2, "cusUpdateTime");
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