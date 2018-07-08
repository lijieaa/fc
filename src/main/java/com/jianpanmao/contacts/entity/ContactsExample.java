package com.jianpanmao.contacts.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactsExample() {
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

        public Criteria andConIdIsNull() {
            addCriterion("con_id is null");
            return (Criteria) this;
        }

        public Criteria andConIdIsNotNull() {
            addCriterion("con_id is not null");
            return (Criteria) this;
        }

        public Criteria andConIdEqualTo(Integer value) {
            addCriterion("con_id =", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotEqualTo(Integer value) {
            addCriterion("con_id <>", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThan(Integer value) {
            addCriterion("con_id >", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("con_id >=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThan(Integer value) {
            addCriterion("con_id <", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThanOrEqualTo(Integer value) {
            addCriterion("con_id <=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdIn(List<Integer> values) {
            addCriterion("con_id in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotIn(List<Integer> values) {
            addCriterion("con_id not in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdBetween(Integer value1, Integer value2) {
            addCriterion("con_id between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotBetween(Integer value1, Integer value2) {
            addCriterion("con_id not between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConNameIsNull() {
            addCriterion("con_name is null");
            return (Criteria) this;
        }

        public Criteria andConNameIsNotNull() {
            addCriterion("con_name is not null");
            return (Criteria) this;
        }

        public Criteria andConNameEqualTo(String value) {
            addCriterion("con_name =", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotEqualTo(String value) {
            addCriterion("con_name <>", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThan(String value) {
            addCriterion("con_name >", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThanOrEqualTo(String value) {
            addCriterion("con_name >=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThan(String value) {
            addCriterion("con_name <", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThanOrEqualTo(String value) {
            addCriterion("con_name <=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLike(String value) {
            addCriterion("con_name like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotLike(String value) {
            addCriterion("con_name not like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameIn(List<String> values) {
            addCriterion("con_name in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotIn(List<String> values) {
            addCriterion("con_name not in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameBetween(String value1, String value2) {
            addCriterion("con_name between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotBetween(String value1, String value2) {
            addCriterion("con_name not between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConTelIsNull() {
            addCriterion("con_tel is null");
            return (Criteria) this;
        }

        public Criteria andConTelIsNotNull() {
            addCriterion("con_tel is not null");
            return (Criteria) this;
        }

        public Criteria andConTelEqualTo(String value) {
            addCriterion("con_tel =", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelNotEqualTo(String value) {
            addCriterion("con_tel <>", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelGreaterThan(String value) {
            addCriterion("con_tel >", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelGreaterThanOrEqualTo(String value) {
            addCriterion("con_tel >=", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelLessThan(String value) {
            addCriterion("con_tel <", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelLessThanOrEqualTo(String value) {
            addCriterion("con_tel <=", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelLike(String value) {
            addCriterion("con_tel like", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelNotLike(String value) {
            addCriterion("con_tel not like", value, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelIn(List<String> values) {
            addCriterion("con_tel in", values, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelNotIn(List<String> values) {
            addCriterion("con_tel not in", values, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelBetween(String value1, String value2) {
            addCriterion("con_tel between", value1, value2, "conTel");
            return (Criteria) this;
        }

        public Criteria andConTelNotBetween(String value1, String value2) {
            addCriterion("con_tel not between", value1, value2, "conTel");
            return (Criteria) this;
        }

        public Criteria andConQqIsNull() {
            addCriterion("con_qq is null");
            return (Criteria) this;
        }

        public Criteria andConQqIsNotNull() {
            addCriterion("con_qq is not null");
            return (Criteria) this;
        }

        public Criteria andConQqEqualTo(String value) {
            addCriterion("con_qq =", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotEqualTo(String value) {
            addCriterion("con_qq <>", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqGreaterThan(String value) {
            addCriterion("con_qq >", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqGreaterThanOrEqualTo(String value) {
            addCriterion("con_qq >=", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLessThan(String value) {
            addCriterion("con_qq <", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLessThanOrEqualTo(String value) {
            addCriterion("con_qq <=", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLike(String value) {
            addCriterion("con_qq like", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotLike(String value) {
            addCriterion("con_qq not like", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqIn(List<String> values) {
            addCriterion("con_qq in", values, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotIn(List<String> values) {
            addCriterion("con_qq not in", values, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqBetween(String value1, String value2) {
            addCriterion("con_qq between", value1, value2, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotBetween(String value1, String value2) {
            addCriterion("con_qq not between", value1, value2, "conQq");
            return (Criteria) this;
        }

        public Criteria andConWechatIsNull() {
            addCriterion("con_wechat is null");
            return (Criteria) this;
        }

        public Criteria andConWechatIsNotNull() {
            addCriterion("con_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andConWechatEqualTo(String value) {
            addCriterion("con_wechat =", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotEqualTo(String value) {
            addCriterion("con_wechat <>", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatGreaterThan(String value) {
            addCriterion("con_wechat >", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatGreaterThanOrEqualTo(String value) {
            addCriterion("con_wechat >=", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLessThan(String value) {
            addCriterion("con_wechat <", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLessThanOrEqualTo(String value) {
            addCriterion("con_wechat <=", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLike(String value) {
            addCriterion("con_wechat like", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotLike(String value) {
            addCriterion("con_wechat not like", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatIn(List<String> values) {
            addCriterion("con_wechat in", values, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotIn(List<String> values) {
            addCriterion("con_wechat not in", values, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatBetween(String value1, String value2) {
            addCriterion("con_wechat between", value1, value2, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotBetween(String value1, String value2) {
            addCriterion("con_wechat not between", value1, value2, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConEmailIsNull() {
            addCriterion("con_email is null");
            return (Criteria) this;
        }

        public Criteria andConEmailIsNotNull() {
            addCriterion("con_email is not null");
            return (Criteria) this;
        }

        public Criteria andConEmailEqualTo(String value) {
            addCriterion("con_email =", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotEqualTo(String value) {
            addCriterion("con_email <>", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailGreaterThan(String value) {
            addCriterion("con_email >", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailGreaterThanOrEqualTo(String value) {
            addCriterion("con_email >=", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLessThan(String value) {
            addCriterion("con_email <", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLessThanOrEqualTo(String value) {
            addCriterion("con_email <=", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLike(String value) {
            addCriterion("con_email like", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotLike(String value) {
            addCriterion("con_email not like", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailIn(List<String> values) {
            addCriterion("con_email in", values, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotIn(List<String> values) {
            addCriterion("con_email not in", values, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailBetween(String value1, String value2) {
            addCriterion("con_email between", value1, value2, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotBetween(String value1, String value2) {
            addCriterion("con_email not between", value1, value2, "conEmail");
            return (Criteria) this;
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

        public Criteria andConCreateTimeIsNull() {
            addCriterion("con_create_time is null");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeIsNotNull() {
            addCriterion("con_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeEqualTo(Date value) {
            addCriterion("con_create_time =", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeNotEqualTo(Date value) {
            addCriterion("con_create_time <>", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeGreaterThan(Date value) {
            addCriterion("con_create_time >", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("con_create_time >=", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeLessThan(Date value) {
            addCriterion("con_create_time <", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("con_create_time <=", value, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeIn(List<Date> values) {
            addCriterion("con_create_time in", values, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeNotIn(List<Date> values) {
            addCriterion("con_create_time not in", values, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeBetween(Date value1, Date value2) {
            addCriterion("con_create_time between", value1, value2, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("con_create_time not between", value1, value2, "conCreateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeIsNull() {
            addCriterion("con_update_time is null");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeIsNotNull() {
            addCriterion("con_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeEqualTo(Date value) {
            addCriterion("con_update_time =", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeNotEqualTo(Date value) {
            addCriterion("con_update_time <>", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeGreaterThan(Date value) {
            addCriterion("con_update_time >", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("con_update_time >=", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeLessThan(Date value) {
            addCriterion("con_update_time <", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("con_update_time <=", value, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeIn(List<Date> values) {
            addCriterion("con_update_time in", values, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeNotIn(List<Date> values) {
            addCriterion("con_update_time not in", values, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("con_update_time between", value1, value2, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andConUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("con_update_time not between", value1, value2, "conUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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