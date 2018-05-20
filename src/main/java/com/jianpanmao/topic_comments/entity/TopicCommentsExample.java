package com.jianpanmao.topic_comments.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopicCommentsExample() {
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

        public Criteria andTopicCommentsIdIsNull() {
            addCriterion("topic_comments_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdIsNotNull() {
            addCriterion("topic_comments_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdEqualTo(Integer value) {
            addCriterion("topic_comments_id =", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdNotEqualTo(Integer value) {
            addCriterion("topic_comments_id <>", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdGreaterThan(Integer value) {
            addCriterion("topic_comments_id >", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_comments_id >=", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdLessThan(Integer value) {
            addCriterion("topic_comments_id <", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_comments_id <=", value, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdIn(List<Integer> values) {
            addCriterion("topic_comments_id in", values, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdNotIn(List<Integer> values) {
            addCriterion("topic_comments_id not in", values, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_comments_id between", value1, value2, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_comments_id not between", value1, value2, "topicCommentsId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
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

        public Criteria andTopicCommentsCreateTimeIsNull() {
            addCriterion("topic_comments_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeIsNotNull() {
            addCriterion("topic_comments_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeEqualTo(Date value) {
            addCriterion("topic_comments_create_time =", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeNotEqualTo(Date value) {
            addCriterion("topic_comments_create_time <>", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeGreaterThan(Date value) {
            addCriterion("topic_comments_create_time >", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("topic_comments_create_time >=", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeLessThan(Date value) {
            addCriterion("topic_comments_create_time <", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("topic_comments_create_time <=", value, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeIn(List<Date> values) {
            addCriterion("topic_comments_create_time in", values, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeNotIn(List<Date> values) {
            addCriterion("topic_comments_create_time not in", values, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeBetween(Date value1, Date value2) {
            addCriterion("topic_comments_create_time between", value1, value2, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("topic_comments_create_time not between", value1, value2, "topicCommentsCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeIsNull() {
            addCriterion("topic_comments_update_time is null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeIsNotNull() {
            addCriterion("topic_comments_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeEqualTo(Date value) {
            addCriterion("topic_comments_update_time =", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeNotEqualTo(Date value) {
            addCriterion("topic_comments_update_time <>", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeGreaterThan(Date value) {
            addCriterion("topic_comments_update_time >", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("topic_comments_update_time >=", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeLessThan(Date value) {
            addCriterion("topic_comments_update_time <", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("topic_comments_update_time <=", value, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeIn(List<Date> values) {
            addCriterion("topic_comments_update_time in", values, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeNotIn(List<Date> values) {
            addCriterion("topic_comments_update_time not in", values, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("topic_comments_update_time between", value1, value2, "topicCommentsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCommentsUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("topic_comments_update_time not between", value1, value2, "topicCommentsUpdateTime");
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