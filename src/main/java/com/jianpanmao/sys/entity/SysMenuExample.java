package com.jianpanmao.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNull() {
            addCriterion("menu_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNotNull() {
            addCriterion("menu_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdEqualTo(Integer value) {
            addCriterion("menu_parent_id =", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotEqualTo(Integer value) {
            addCriterion("menu_parent_id <>", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThan(Integer value) {
            addCriterion("menu_parent_id >", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id >=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThan(Integer value) {
            addCriterion("menu_parent_id <", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id <=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIn(List<Integer> values) {
            addCriterion("menu_parent_id in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotIn(List<Integer> values) {
            addCriterion("menu_parent_id not in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id not between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionIsNull() {
            addCriterion("menu_prmission is null");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionIsNotNull() {
            addCriterion("menu_prmission is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionEqualTo(String value) {
            addCriterion("menu_prmission =", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionNotEqualTo(String value) {
            addCriterion("menu_prmission <>", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionGreaterThan(String value) {
            addCriterion("menu_prmission >", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionGreaterThanOrEqualTo(String value) {
            addCriterion("menu_prmission >=", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionLessThan(String value) {
            addCriterion("menu_prmission <", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionLessThanOrEqualTo(String value) {
            addCriterion("menu_prmission <=", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionLike(String value) {
            addCriterion("menu_prmission like", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionNotLike(String value) {
            addCriterion("menu_prmission not like", value, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionIn(List<String> values) {
            addCriterion("menu_prmission in", values, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionNotIn(List<String> values) {
            addCriterion("menu_prmission not in", values, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionBetween(String value1, String value2) {
            addCriterion("menu_prmission between", value1, value2, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuPrmissionNotBetween(String value1, String value2) {
            addCriterion("menu_prmission not between", value1, value2, "menuPrmission");
            return (Criteria) this;
        }

        public Criteria andMenuSortdIsNull() {
            addCriterion("menu_sortd is null");
            return (Criteria) this;
        }

        public Criteria andMenuSortdIsNotNull() {
            addCriterion("menu_sortd is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSortdEqualTo(Integer value) {
            addCriterion("menu_sortd =", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdNotEqualTo(Integer value) {
            addCriterion("menu_sortd <>", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdGreaterThan(Integer value) {
            addCriterion("menu_sortd >", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_sortd >=", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdLessThan(Integer value) {
            addCriterion("menu_sortd <", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_sortd <=", value, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdIn(List<Integer> values) {
            addCriterion("menu_sortd in", values, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdNotIn(List<Integer> values) {
            addCriterion("menu_sortd not in", values, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdBetween(Integer value1, Integer value2) {
            addCriterion("menu_sortd between", value1, value2, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuSortdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_sortd not between", value1, value2, "menuSortd");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayIsNull() {
            addCriterion("menu_display is null");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayIsNotNull() {
            addCriterion("menu_display is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayEqualTo(Byte value) {
            addCriterion("menu_display =", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayNotEqualTo(Byte value) {
            addCriterion("menu_display <>", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayGreaterThan(Byte value) {
            addCriterion("menu_display >", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayGreaterThanOrEqualTo(Byte value) {
            addCriterion("menu_display >=", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayLessThan(Byte value) {
            addCriterion("menu_display <", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayLessThanOrEqualTo(Byte value) {
            addCriterion("menu_display <=", value, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayIn(List<Byte> values) {
            addCriterion("menu_display in", values, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayNotIn(List<Byte> values) {
            addCriterion("menu_display not in", values, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayBetween(Byte value1, Byte value2) {
            addCriterion("menu_display between", value1, value2, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andMenuDisplayNotBetween(Byte value1, Byte value2) {
            addCriterion("menu_display not between", value1, value2, "menuDisplay");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
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