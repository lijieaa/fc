package com.jianpanmao.projectComments.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectCommentsExample() {
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

        public Criteria andProjectCommentsIdIsNull() {
            addCriterion("project_comments_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdIsNotNull() {
            addCriterion("project_comments_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdEqualTo(Integer value) {
            addCriterion("project_comments_id =", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdNotEqualTo(Integer value) {
            addCriterion("project_comments_id <>", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdGreaterThan(Integer value) {
            addCriterion("project_comments_id >", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_comments_id >=", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdLessThan(Integer value) {
            addCriterion("project_comments_id <", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_comments_id <=", value, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdIn(List<Integer> values) {
            addCriterion("project_comments_id in", values, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdNotIn(List<Integer> values) {
            addCriterion("project_comments_id not in", values, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdBetween(Integer value1, Integer value2) {
            addCriterion("project_comments_id between", value1, value2, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_comments_id not between", value1, value2, "projectCommentsId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentIsNull() {
            addCriterion("project_comments_parent is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentIsNotNull() {
            addCriterion("project_comments_parent is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentEqualTo(Integer value) {
            addCriterion("project_comments_parent =", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentNotEqualTo(Integer value) {
            addCriterion("project_comments_parent <>", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentGreaterThan(Integer value) {
            addCriterion("project_comments_parent >", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_comments_parent >=", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentLessThan(Integer value) {
            addCriterion("project_comments_parent <", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentLessThanOrEqualTo(Integer value) {
            addCriterion("project_comments_parent <=", value, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentIn(List<Integer> values) {
            addCriterion("project_comments_parent in", values, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentNotIn(List<Integer> values) {
            addCriterion("project_comments_parent not in", values, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentBetween(Integer value1, Integer value2) {
            addCriterion("project_comments_parent between", value1, value2, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsParentNotBetween(Integer value1, Integer value2) {
            addCriterion("project_comments_parent not between", value1, value2, "projectCommentsParent");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameIsNull() {
            addCriterion("project_comments_nickname is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameIsNotNull() {
            addCriterion("project_comments_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameEqualTo(String value) {
            addCriterion("project_comments_nickname =", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameNotEqualTo(String value) {
            addCriterion("project_comments_nickname <>", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameGreaterThan(String value) {
            addCriterion("project_comments_nickname >", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("project_comments_nickname >=", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameLessThan(String value) {
            addCriterion("project_comments_nickname <", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameLessThanOrEqualTo(String value) {
            addCriterion("project_comments_nickname <=", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameLike(String value) {
            addCriterion("project_comments_nickname like", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameNotLike(String value) {
            addCriterion("project_comments_nickname not like", value, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameIn(List<String> values) {
            addCriterion("project_comments_nickname in", values, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameNotIn(List<String> values) {
            addCriterion("project_comments_nickname not in", values, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameBetween(String value1, String value2) {
            addCriterion("project_comments_nickname between", value1, value2, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsNicknameNotBetween(String value1, String value2) {
            addCriterion("project_comments_nickname not between", value1, value2, "projectCommentsNickname");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeIsNull() {
            addCriterion("project_comments_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeIsNotNull() {
            addCriterion("project_comments_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeEqualTo(Byte value) {
            addCriterion("project_comments_type =", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeNotEqualTo(Byte value) {
            addCriterion("project_comments_type <>", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeGreaterThan(Byte value) {
            addCriterion("project_comments_type >", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_comments_type >=", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeLessThan(Byte value) {
            addCriterion("project_comments_type <", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeLessThanOrEqualTo(Byte value) {
            addCriterion("project_comments_type <=", value, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeIn(List<Byte> values) {
            addCriterion("project_comments_type in", values, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeNotIn(List<Byte> values) {
            addCriterion("project_comments_type not in", values, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeBetween(Byte value1, Byte value2) {
            addCriterion("project_comments_type between", value1, value2, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("project_comments_type not between", value1, value2, "projectCommentsType");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusIsNull() {
            addCriterion("project_comments_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusIsNotNull() {
            addCriterion("project_comments_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusEqualTo(Byte value) {
            addCriterion("project_comments_status =", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusNotEqualTo(Byte value) {
            addCriterion("project_comments_status <>", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusGreaterThan(Byte value) {
            addCriterion("project_comments_status >", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_comments_status >=", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusLessThan(Byte value) {
            addCriterion("project_comments_status <", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusLessThanOrEqualTo(Byte value) {
            addCriterion("project_comments_status <=", value, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusIn(List<Byte> values) {
            addCriterion("project_comments_status in", values, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusNotIn(List<Byte> values) {
            addCriterion("project_comments_status not in", values, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusBetween(Byte value1, Byte value2) {
            addCriterion("project_comments_status between", value1, value2, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("project_comments_status not between", value1, value2, "projectCommentsStatus");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeIsNull() {
            addCriterion("project_comments_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeIsNotNull() {
            addCriterion("project_comments_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeEqualTo(Date value) {
            addCriterion("project_comments_create_time =", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeNotEqualTo(Date value) {
            addCriterion("project_comments_create_time <>", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeGreaterThan(Date value) {
            addCriterion("project_comments_create_time >", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_comments_create_time >=", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeLessThan(Date value) {
            addCriterion("project_comments_create_time <", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_comments_create_time <=", value, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeIn(List<Date> values) {
            addCriterion("project_comments_create_time in", values, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeNotIn(List<Date> values) {
            addCriterion("project_comments_create_time not in", values, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeBetween(Date value1, Date value2) {
            addCriterion("project_comments_create_time between", value1, value2, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_comments_create_time not between", value1, value2, "projectCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeIsNull() {
            addCriterion("project_comments_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeIsNotNull() {
            addCriterion("project_comments_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeEqualTo(Date value) {
            addCriterion("project_comments_update_time =", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeNotEqualTo(Date value) {
            addCriterion("project_comments_update_time <>", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeGreaterThan(Date value) {
            addCriterion("project_comments_update_time >", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_comments_update_time >=", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeLessThan(Date value) {
            addCriterion("project_comments_update_time <", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_comments_update_time <=", value, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeIn(List<Date> values) {
            addCriterion("project_comments_update_time in", values, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeNotIn(List<Date> values) {
            addCriterion("project_comments_update_time not in", values, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("project_comments_update_time between", value1, value2, "projectCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCommentsUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_comments_update_time not between", value1, value2, "projectCommentsUpdateTime");
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