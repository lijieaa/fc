package com.jianpanmao.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DingtalkUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DingtalkUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("`position` is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("`position` is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("`position` =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("`position` <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("`position` >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("`position` >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("`position` <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("`position` <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("`position` like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("`position` not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("`position` in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("`position` not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("`position` between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("`position` not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNull() {
            addCriterion("workPlace is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNotNull() {
            addCriterion("workPlace is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceEqualTo(String value) {
            addCriterion("workPlace =", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotEqualTo(String value) {
            addCriterion("workPlace <>", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThan(String value) {
            addCriterion("workPlace >", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("workPlace >=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThan(String value) {
            addCriterion("workPlace <", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("workPlace <=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLike(String value) {
            addCriterion("workPlace like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotLike(String value) {
            addCriterion("workPlace not like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIn(List<String> values) {
            addCriterion("workPlace in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotIn(List<String> values) {
            addCriterion("workPlace not in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceBetween(String value1, String value2) {
            addCriterion("workPlace between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotBetween(String value1, String value2) {
            addCriterion("workPlace not between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andOrgemailIsNull() {
            addCriterion("orgEmail is null");
            return (Criteria) this;
        }

        public Criteria andOrgemailIsNotNull() {
            addCriterion("orgEmail is not null");
            return (Criteria) this;
        }

        public Criteria andOrgemailEqualTo(String value) {
            addCriterion("orgEmail =", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailNotEqualTo(String value) {
            addCriterion("orgEmail <>", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailGreaterThan(String value) {
            addCriterion("orgEmail >", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailGreaterThanOrEqualTo(String value) {
            addCriterion("orgEmail >=", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailLessThan(String value) {
            addCriterion("orgEmail <", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailLessThanOrEqualTo(String value) {
            addCriterion("orgEmail <=", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailLike(String value) {
            addCriterion("orgEmail like", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailNotLike(String value) {
            addCriterion("orgEmail not like", value, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailIn(List<String> values) {
            addCriterion("orgEmail in", values, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailNotIn(List<String> values) {
            addCriterion("orgEmail not in", values, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailBetween(String value1, String value2) {
            addCriterion("orgEmail between", value1, value2, "orgemail");
            return (Criteria) this;
        }

        public Criteria andOrgemailNotBetween(String value1, String value2) {
            addCriterion("orgEmail not between", value1, value2, "orgemail");
            return (Criteria) this;
        }

        public Criteria andJobnumberIsNull() {
            addCriterion("jobnumber is null");
            return (Criteria) this;
        }

        public Criteria andJobnumberIsNotNull() {
            addCriterion("jobnumber is not null");
            return (Criteria) this;
        }

        public Criteria andJobnumberEqualTo(String value) {
            addCriterion("jobnumber =", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotEqualTo(String value) {
            addCriterion("jobnumber <>", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberGreaterThan(String value) {
            addCriterion("jobnumber >", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberGreaterThanOrEqualTo(String value) {
            addCriterion("jobnumber >=", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberLessThan(String value) {
            addCriterion("jobnumber <", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberLessThanOrEqualTo(String value) {
            addCriterion("jobnumber <=", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberLike(String value) {
            addCriterion("jobnumber like", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotLike(String value) {
            addCriterion("jobnumber not like", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberIn(List<String> values) {
            addCriterion("jobnumber in", values, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotIn(List<String> values) {
            addCriterion("jobnumber not in", values, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberBetween(String value1, String value2) {
            addCriterion("jobnumber between", value1, value2, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotBetween(String value1, String value2) {
            addCriterion("jobnumber not between", value1, value2, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andIshideIsNull() {
            addCriterion("isHide is null");
            return (Criteria) this;
        }

        public Criteria andIshideIsNotNull() {
            addCriterion("isHide is not null");
            return (Criteria) this;
        }

        public Criteria andIshideEqualTo(Boolean value) {
            addCriterion("isHide =", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotEqualTo(Boolean value) {
            addCriterion("isHide <>", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThan(Boolean value) {
            addCriterion("isHide >", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isHide >=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThan(Boolean value) {
            addCriterion("isHide <", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThanOrEqualTo(Boolean value) {
            addCriterion("isHide <=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideIn(List<Boolean> values) {
            addCriterion("isHide in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotIn(List<Boolean> values) {
            addCriterion("isHide not in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideBetween(Boolean value1, Boolean value2) {
            addCriterion("isHide between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isHide not between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andIsseniorIsNull() {
            addCriterion("isSenior is null");
            return (Criteria) this;
        }

        public Criteria andIsseniorIsNotNull() {
            addCriterion("isSenior is not null");
            return (Criteria) this;
        }

        public Criteria andIsseniorEqualTo(Boolean value) {
            addCriterion("isSenior =", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorNotEqualTo(Boolean value) {
            addCriterion("isSenior <>", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorGreaterThan(Boolean value) {
            addCriterion("isSenior >", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isSenior >=", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorLessThan(Boolean value) {
            addCriterion("isSenior <", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorLessThanOrEqualTo(Boolean value) {
            addCriterion("isSenior <=", value, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorIn(List<Boolean> values) {
            addCriterion("isSenior in", values, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorNotIn(List<Boolean> values) {
            addCriterion("isSenior not in", values, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorBetween(Boolean value1, Boolean value2) {
            addCriterion("isSenior between", value1, value2, "issenior");
            return (Criteria) this;
        }

        public Criteria andIsseniorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isSenior not between", value1, value2, "issenior");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNull() {
            addCriterion("is_admin is null");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNotNull() {
            addCriterion("is_admin is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdminEqualTo(Integer value) {
            addCriterion("is_admin =", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotEqualTo(Integer value) {
            addCriterion("is_admin <>", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThan(Integer value) {
            addCriterion("is_admin >", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_admin >=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThan(Integer value) {
            addCriterion("is_admin <", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThanOrEqualTo(Integer value) {
            addCriterion("is_admin <=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminIn(List<Integer> values) {
            addCriterion("is_admin in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotIn(List<Integer> values) {
            addCriterion("is_admin not in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminBetween(Integer value1, Integer value2) {
            addCriterion("is_admin between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("is_admin not between", value1, value2, "isAdmin");
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