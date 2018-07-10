package com.jianpanmao.contacts.entity;

import java.util.ArrayList;
import java.util.List;

public class Contact2RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Contact2RoleExample() {
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

        public Criteria andConRolIsNull() {
            addCriterion("con_rol is null");
            return (Criteria) this;
        }

        public Criteria andConRolIsNotNull() {
            addCriterion("con_rol is not null");
            return (Criteria) this;
        }

        public Criteria andConRolEqualTo(Integer value) {
            addCriterion("con_rol =", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolNotEqualTo(Integer value) {
            addCriterion("con_rol <>", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolGreaterThan(Integer value) {
            addCriterion("con_rol >", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolGreaterThanOrEqualTo(Integer value) {
            addCriterion("con_rol >=", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolLessThan(Integer value) {
            addCriterion("con_rol <", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolLessThanOrEqualTo(Integer value) {
            addCriterion("con_rol <=", value, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolIn(List<Integer> values) {
            addCriterion("con_rol in", values, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolNotIn(List<Integer> values) {
            addCriterion("con_rol not in", values, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolBetween(Integer value1, Integer value2) {
            addCriterion("con_rol between", value1, value2, "conRol");
            return (Criteria) this;
        }

        public Criteria andConRolNotBetween(Integer value1, Integer value2) {
            addCriterion("con_rol not between", value1, value2, "conRol");
            return (Criteria) this;
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

        public Criteria andRolIdIsNull() {
            addCriterion("rol_id is null");
            return (Criteria) this;
        }

        public Criteria andRolIdIsNotNull() {
            addCriterion("rol_id is not null");
            return (Criteria) this;
        }

        public Criteria andRolIdEqualTo(Integer value) {
            addCriterion("rol_id =", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotEqualTo(Integer value) {
            addCriterion("rol_id <>", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdGreaterThan(Integer value) {
            addCriterion("rol_id >", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rol_id >=", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdLessThan(Integer value) {
            addCriterion("rol_id <", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdLessThanOrEqualTo(Integer value) {
            addCriterion("rol_id <=", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdIn(List<Integer> values) {
            addCriterion("rol_id in", values, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotIn(List<Integer> values) {
            addCriterion("rol_id not in", values, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdBetween(Integer value1, Integer value2) {
            addCriterion("rol_id between", value1, value2, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rol_id not between", value1, value2, "rolId");
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