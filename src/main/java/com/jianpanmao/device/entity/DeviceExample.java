package com.jianpanmao.device.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNull() {
            addCriterion("operate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNotNull() {
            addCriterion("operate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdEqualTo(Integer value) {
            addCriterion("operate_user_id =", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotEqualTo(Integer value) {
            addCriterion("operate_user_id <>", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThan(Integer value) {
            addCriterion("operate_user_id >", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_user_id >=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThan(Integer value) {
            addCriterion("operate_user_id <", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("operate_user_id <=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIn(List<Integer> values) {
            addCriterion("operate_user_id in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotIn(List<Integer> values) {
            addCriterion("operate_user_id not in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("operate_user_id between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_user_id not between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdIsNull() {
            addCriterion("transcribe_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdIsNotNull() {
            addCriterion("transcribe_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdEqualTo(Integer value) {
            addCriterion("transcribe_user_id =", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdNotEqualTo(Integer value) {
            addCriterion("transcribe_user_id <>", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdGreaterThan(Integer value) {
            addCriterion("transcribe_user_id >", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transcribe_user_id >=", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdLessThan(Integer value) {
            addCriterion("transcribe_user_id <", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("transcribe_user_id <=", value, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdIn(List<Integer> values) {
            addCriterion("transcribe_user_id in", values, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdNotIn(List<Integer> values) {
            addCriterion("transcribe_user_id not in", values, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("transcribe_user_id between", value1, value2, "transcribeUserId");
            return (Criteria) this;
        }

        public Criteria andTranscribeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transcribe_user_id not between", value1, value2, "transcribeUserId");
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

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Byte value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Byte value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Byte value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Byte value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<Byte> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Byte> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Byte value1, Byte value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXIsNull() {
            addCriterion("device_location_x is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXIsNotNull() {
            addCriterion("device_location_x is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXEqualTo(String value) {
            addCriterion("device_location_x =", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXNotEqualTo(String value) {
            addCriterion("device_location_x <>", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXGreaterThan(String value) {
            addCriterion("device_location_x >", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXGreaterThanOrEqualTo(String value) {
            addCriterion("device_location_x >=", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXLessThan(String value) {
            addCriterion("device_location_x <", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXLessThanOrEqualTo(String value) {
            addCriterion("device_location_x <=", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXLike(String value) {
            addCriterion("device_location_x like", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXNotLike(String value) {
            addCriterion("device_location_x not like", value, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXIn(List<String> values) {
            addCriterion("device_location_x in", values, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXNotIn(List<String> values) {
            addCriterion("device_location_x not in", values, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXBetween(String value1, String value2) {
            addCriterion("device_location_x between", value1, value2, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationXNotBetween(String value1, String value2) {
            addCriterion("device_location_x not between", value1, value2, "deviceLocationX");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYIsNull() {
            addCriterion("device_location_y is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYIsNotNull() {
            addCriterion("device_location_y is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYEqualTo(String value) {
            addCriterion("device_location_y =", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYNotEqualTo(String value) {
            addCriterion("device_location_y <>", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYGreaterThan(String value) {
            addCriterion("device_location_y >", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYGreaterThanOrEqualTo(String value) {
            addCriterion("device_location_y >=", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYLessThan(String value) {
            addCriterion("device_location_y <", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYLessThanOrEqualTo(String value) {
            addCriterion("device_location_y <=", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYLike(String value) {
            addCriterion("device_location_y like", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYNotLike(String value) {
            addCriterion("device_location_y not like", value, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYIn(List<String> values) {
            addCriterion("device_location_y in", values, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYNotIn(List<String> values) {
            addCriterion("device_location_y not in", values, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYBetween(String value1, String value2) {
            addCriterion("device_location_y between", value1, value2, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceLocationYNotBetween(String value1, String value2) {
            addCriterion("device_location_y not between", value1, value2, "deviceLocationY");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeIsNull() {
            addCriterion("device_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeIsNotNull() {
            addCriterion("device_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeEqualTo(Date value) {
            addCriterion("device_create_time =", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeNotEqualTo(Date value) {
            addCriterion("device_create_time <>", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeGreaterThan(Date value) {
            addCriterion("device_create_time >", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_create_time >=", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeLessThan(Date value) {
            addCriterion("device_create_time <", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_create_time <=", value, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeIn(List<Date> values) {
            addCriterion("device_create_time in", values, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeNotIn(List<Date> values) {
            addCriterion("device_create_time not in", values, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeBetween(Date value1, Date value2) {
            addCriterion("device_create_time between", value1, value2, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_create_time not between", value1, value2, "deviceCreateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIsNull() {
            addCriterion("device_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIsNotNull() {
            addCriterion("device_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeEqualTo(Date value) {
            addCriterion("device_update_time =", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotEqualTo(Date value) {
            addCriterion("device_update_time <>", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeGreaterThan(Date value) {
            addCriterion("device_update_time >", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_update_time >=", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeLessThan(Date value) {
            addCriterion("device_update_time <", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_update_time <=", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIn(List<Date> values) {
            addCriterion("device_update_time in", values, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotIn(List<Date> values) {
            addCriterion("device_update_time not in", values, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("device_update_time between", value1, value2, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_update_time not between", value1, value2, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNull() {
            addCriterion("manufacturer_id is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("manufacturer_id is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdEqualTo(Integer value) {
            addCriterion("manufacturer_id =", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotEqualTo(Integer value) {
            addCriterion("manufacturer_id <>", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThan(Integer value) {
            addCriterion("manufacturer_id >", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manufacturer_id >=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThan(Integer value) {
            addCriterion("manufacturer_id <", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manufacturer_id <=", value, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdIn(List<Integer> values) {
            addCriterion("manufacturer_id in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotIn(List<Integer> values) {
            addCriterion("manufacturer_id not in", values, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer_id between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andManufacturerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer_id not between", value1, value2, "manufacturerId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
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