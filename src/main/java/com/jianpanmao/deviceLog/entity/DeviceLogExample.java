package com.jianpanmao.deviceLog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLogExample() {
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

        public Criteria andDeviceLogIdIsNull() {
            addCriterion("device_log_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdIsNotNull() {
            addCriterion("device_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdEqualTo(Integer value) {
            addCriterion("device_log_id =", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotEqualTo(Integer value) {
            addCriterion("device_log_id <>", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdGreaterThan(Integer value) {
            addCriterion("device_log_id >", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_log_id >=", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdLessThan(Integer value) {
            addCriterion("device_log_id <", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_log_id <=", value, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdIn(List<Integer> values) {
            addCriterion("device_log_id in", values, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotIn(List<Integer> values) {
            addCriterion("device_log_id not in", values, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdBetween(Integer value1, Integer value2) {
            addCriterion("device_log_id between", value1, value2, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_log_id not between", value1, value2, "deviceLogId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumIsNull() {
            addCriterion("device_production_num is null");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumIsNotNull() {
            addCriterion("device_production_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumEqualTo(String value) {
            addCriterion("device_production_num =", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumNotEqualTo(String value) {
            addCriterion("device_production_num <>", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumGreaterThan(String value) {
            addCriterion("device_production_num >", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumGreaterThanOrEqualTo(String value) {
            addCriterion("device_production_num >=", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumLessThan(String value) {
            addCriterion("device_production_num <", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumLessThanOrEqualTo(String value) {
            addCriterion("device_production_num <=", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumLike(String value) {
            addCriterion("device_production_num like", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumNotLike(String value) {
            addCriterion("device_production_num not like", value, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumIn(List<String> values) {
            addCriterion("device_production_num in", values, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumNotIn(List<String> values) {
            addCriterion("device_production_num not in", values, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumBetween(String value1, String value2) {
            addCriterion("device_production_num between", value1, value2, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andDeviceProductionNumNotBetween(String value1, String value2) {
            addCriterion("device_production_num not between", value1, value2, "deviceProductionNum");
            return (Criteria) this;
        }

        public Criteria andOperateCommandIsNull() {
            addCriterion("operate_command is null");
            return (Criteria) this;
        }

        public Criteria andOperateCommandIsNotNull() {
            addCriterion("operate_command is not null");
            return (Criteria) this;
        }

        public Criteria andOperateCommandEqualTo(String value) {
            addCriterion("operate_command =", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandNotEqualTo(String value) {
            addCriterion("operate_command <>", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandGreaterThan(String value) {
            addCriterion("operate_command >", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandGreaterThanOrEqualTo(String value) {
            addCriterion("operate_command >=", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandLessThan(String value) {
            addCriterion("operate_command <", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandLessThanOrEqualTo(String value) {
            addCriterion("operate_command <=", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandLike(String value) {
            addCriterion("operate_command like", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandNotLike(String value) {
            addCriterion("operate_command not like", value, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandIn(List<String> values) {
            addCriterion("operate_command in", values, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandNotIn(List<String> values) {
            addCriterion("operate_command not in", values, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandBetween(String value1, String value2) {
            addCriterion("operate_command between", value1, value2, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandNotBetween(String value1, String value2) {
            addCriterion("operate_command not between", value1, value2, "operateCommand");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescIsNull() {
            addCriterion("operate_command_desc is null");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescIsNotNull() {
            addCriterion("operate_command_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescEqualTo(String value) {
            addCriterion("operate_command_desc =", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescNotEqualTo(String value) {
            addCriterion("operate_command_desc <>", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescGreaterThan(String value) {
            addCriterion("operate_command_desc >", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescGreaterThanOrEqualTo(String value) {
            addCriterion("operate_command_desc >=", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescLessThan(String value) {
            addCriterion("operate_command_desc <", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescLessThanOrEqualTo(String value) {
            addCriterion("operate_command_desc <=", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescLike(String value) {
            addCriterion("operate_command_desc like", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescNotLike(String value) {
            addCriterion("operate_command_desc not like", value, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescIn(List<String> values) {
            addCriterion("operate_command_desc in", values, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescNotIn(List<String> values) {
            addCriterion("operate_command_desc not in", values, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescBetween(String value1, String value2) {
            addCriterion("operate_command_desc between", value1, value2, "operateCommandDesc");
            return (Criteria) this;
        }

        public Criteria andOperateCommandDescNotBetween(String value1, String value2) {
            addCriterion("operate_command_desc not between", value1, value2, "operateCommandDesc");
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

        public Criteria andDeviceLogCreateTimeIsNull() {
            addCriterion("device_log_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeIsNotNull() {
            addCriterion("device_log_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeEqualTo(Date value) {
            addCriterion("device_log_create_time =", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeNotEqualTo(Date value) {
            addCriterion("device_log_create_time <>", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeGreaterThan(Date value) {
            addCriterion("device_log_create_time >", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_log_create_time >=", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeLessThan(Date value) {
            addCriterion("device_log_create_time <", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_log_create_time <=", value, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeIn(List<Date> values) {
            addCriterion("device_log_create_time in", values, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeNotIn(List<Date> values) {
            addCriterion("device_log_create_time not in", values, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeBetween(Date value1, Date value2) {
            addCriterion("device_log_create_time between", value1, value2, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_log_create_time not between", value1, value2, "deviceLogCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeIsNull() {
            addCriterion("device_log_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeIsNotNull() {
            addCriterion("device_log_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeEqualTo(Date value) {
            addCriterion("device_log_update_time =", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeNotEqualTo(Date value) {
            addCriterion("device_log_update_time <>", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeGreaterThan(Date value) {
            addCriterion("device_log_update_time >", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_log_update_time >=", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeLessThan(Date value) {
            addCriterion("device_log_update_time <", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_log_update_time <=", value, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeIn(List<Date> values) {
            addCriterion("device_log_update_time in", values, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeNotIn(List<Date> values) {
            addCriterion("device_log_update_time not in", values, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("device_log_update_time between", value1, value2, "deviceLogUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceLogUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_log_update_time not between", value1, value2, "deviceLogUpdateTime");
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