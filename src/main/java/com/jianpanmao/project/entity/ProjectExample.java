package com.jianpanmao.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andProjectContactUserIdIsNull() {
            addCriterion("project_contact_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdIsNotNull() {
            addCriterion("project_contact_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdEqualTo(Integer value) {
            addCriterion("project_contact_user_id =", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdNotEqualTo(Integer value) {
            addCriterion("project_contact_user_id <>", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdGreaterThan(Integer value) {
            addCriterion("project_contact_user_id >", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_contact_user_id >=", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdLessThan(Integer value) {
            addCriterion("project_contact_user_id <", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_contact_user_id <=", value, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdIn(List<Integer> values) {
            addCriterion("project_contact_user_id in", values, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdNotIn(List<Integer> values) {
            addCriterion("project_contact_user_id not in", values, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdBetween(Integer value1, Integer value2) {
            addCriterion("project_contact_user_id between", value1, value2, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectContactUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_contact_user_id not between", value1, value2, "projectContactUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdIsNull() {
            addCriterion("project_create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdIsNotNull() {
            addCriterion("project_create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdEqualTo(Integer value) {
            addCriterion("project_create_user_id =", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdNotEqualTo(Integer value) {
            addCriterion("project_create_user_id <>", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdGreaterThan(Integer value) {
            addCriterion("project_create_user_id >", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_create_user_id >=", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdLessThan(Integer value) {
            addCriterion("project_create_user_id <", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_create_user_id <=", value, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdIn(List<Integer> values) {
            addCriterion("project_create_user_id in", values, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdNotIn(List<Integer> values) {
            addCriterion("project_create_user_id not in", values, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("project_create_user_id between", value1, value2, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_create_user_id not between", value1, value2, "projectCreateUserId");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactIsNull() {
            addCriterion("project_owner_contact is null");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactIsNotNull() {
            addCriterion("project_owner_contact is not null");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactEqualTo(String value) {
            addCriterion("project_owner_contact =", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactNotEqualTo(String value) {
            addCriterion("project_owner_contact <>", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactGreaterThan(String value) {
            addCriterion("project_owner_contact >", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactGreaterThanOrEqualTo(String value) {
            addCriterion("project_owner_contact >=", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactLessThan(String value) {
            addCriterion("project_owner_contact <", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactLessThanOrEqualTo(String value) {
            addCriterion("project_owner_contact <=", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactLike(String value) {
            addCriterion("project_owner_contact like", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactNotLike(String value) {
            addCriterion("project_owner_contact not like", value, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactIn(List<String> values) {
            addCriterion("project_owner_contact in", values, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactNotIn(List<String> values) {
            addCriterion("project_owner_contact not in", values, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactBetween(String value1, String value2) {
            addCriterion("project_owner_contact between", value1, value2, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactNotBetween(String value1, String value2) {
            addCriterion("project_owner_contact not between", value1, value2, "projectOwnerContact");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelIsNull() {
            addCriterion("project_owner_contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelIsNotNull() {
            addCriterion("project_owner_contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelEqualTo(String value) {
            addCriterion("project_owner_contact_tel =", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelNotEqualTo(String value) {
            addCriterion("project_owner_contact_tel <>", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelGreaterThan(String value) {
            addCriterion("project_owner_contact_tel >", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("project_owner_contact_tel >=", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelLessThan(String value) {
            addCriterion("project_owner_contact_tel <", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelLessThanOrEqualTo(String value) {
            addCriterion("project_owner_contact_tel <=", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelLike(String value) {
            addCriterion("project_owner_contact_tel like", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelNotLike(String value) {
            addCriterion("project_owner_contact_tel not like", value, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelIn(List<String> values) {
            addCriterion("project_owner_contact_tel in", values, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelNotIn(List<String> values) {
            addCriterion("project_owner_contact_tel not in", values, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelBetween(String value1, String value2) {
            addCriterion("project_owner_contact_tel between", value1, value2, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectOwnerContactTelNotBetween(String value1, String value2) {
            addCriterion("project_owner_contact_tel not between", value1, value2, "projectOwnerContactTel");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(Byte value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(Byte value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(Byte value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(Byte value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(Byte value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<Byte> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<Byte> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(Byte value1, Byte value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeIsNull() {
            addCriterion("project_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeIsNotNull() {
            addCriterion("project_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeEqualTo(Date value) {
            addCriterion("project_create_time =", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeNotEqualTo(Date value) {
            addCriterion("project_create_time <>", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeGreaterThan(Date value) {
            addCriterion("project_create_time >", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_create_time >=", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeLessThan(Date value) {
            addCriterion("project_create_time <", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_create_time <=", value, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeIn(List<Date> values) {
            addCriterion("project_create_time in", values, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeNotIn(List<Date> values) {
            addCriterion("project_create_time not in", values, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeBetween(Date value1, Date value2) {
            addCriterion("project_create_time between", value1, value2, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_create_time not between", value1, value2, "projectCreateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeIsNull() {
            addCriterion("project_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeIsNotNull() {
            addCriterion("project_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeEqualTo(Date value) {
            addCriterion("project_update_time =", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeNotEqualTo(Date value) {
            addCriterion("project_update_time <>", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeGreaterThan(Date value) {
            addCriterion("project_update_time >", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_update_time >=", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeLessThan(Date value) {
            addCriterion("project_update_time <", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_update_time <=", value, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeIn(List<Date> values) {
            addCriterion("project_update_time in", values, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeNotIn(List<Date> values) {
            addCriterion("project_update_time not in", values, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("project_update_time between", value1, value2, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_update_time not between", value1, value2, "projectUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProjectLogoIsNull() {
            addCriterion("project_logo is null");
            return (Criteria) this;
        }

        public Criteria andProjectLogoIsNotNull() {
            addCriterion("project_logo is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLogoEqualTo(String value) {
            addCriterion("project_logo =", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoNotEqualTo(String value) {
            addCriterion("project_logo <>", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoGreaterThan(String value) {
            addCriterion("project_logo >", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoGreaterThanOrEqualTo(String value) {
            addCriterion("project_logo >=", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoLessThan(String value) {
            addCriterion("project_logo <", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoLessThanOrEqualTo(String value) {
            addCriterion("project_logo <=", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoLike(String value) {
            addCriterion("project_logo like", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoNotLike(String value) {
            addCriterion("project_logo not like", value, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoIn(List<String> values) {
            addCriterion("project_logo in", values, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoNotIn(List<String> values) {
            addCriterion("project_logo not in", values, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoBetween(String value1, String value2) {
            addCriterion("project_logo between", value1, value2, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectLogoNotBetween(String value1, String value2) {
            addCriterion("project_logo not between", value1, value2, "projectLogo");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusIsNull() {
            addCriterion("project_topic_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusIsNotNull() {
            addCriterion("project_topic_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusEqualTo(Byte value) {
            addCriterion("project_topic_status =", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusNotEqualTo(Byte value) {
            addCriterion("project_topic_status <>", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusGreaterThan(Byte value) {
            addCriterion("project_topic_status >", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_topic_status >=", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusLessThan(Byte value) {
            addCriterion("project_topic_status <", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusLessThanOrEqualTo(Byte value) {
            addCriterion("project_topic_status <=", value, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusIn(List<Byte> values) {
            addCriterion("project_topic_status in", values, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusNotIn(List<Byte> values) {
            addCriterion("project_topic_status not in", values, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusBetween(Byte value1, Byte value2) {
            addCriterion("project_topic_status between", value1, value2, "projectTopicStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTopicStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("project_topic_status not between", value1, value2, "projectTopicStatus");
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