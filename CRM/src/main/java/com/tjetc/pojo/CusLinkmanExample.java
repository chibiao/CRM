package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class CusLinkmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CusLinkmanExample() {
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

        public Criteria andLkmidIsNull() {
            addCriterion("lkmid is null");
            return (Criteria) this;
        }

        public Criteria andLkmidIsNotNull() {
            addCriterion("lkmid is not null");
            return (Criteria) this;
        }

        public Criteria andLkmidEqualTo(Integer value) {
            addCriterion("lkmid =", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidNotEqualTo(Integer value) {
            addCriterion("lkmid <>", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidGreaterThan(Integer value) {
            addCriterion("lkmid >", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lkmid >=", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidLessThan(Integer value) {
            addCriterion("lkmid <", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidLessThanOrEqualTo(Integer value) {
            addCriterion("lkmid <=", value, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidIn(List<Integer> values) {
            addCriterion("lkmid in", values, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidNotIn(List<Integer> values) {
            addCriterion("lkmid not in", values, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidBetween(Integer value1, Integer value2) {
            addCriterion("lkmid between", value1, value2, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmidNotBetween(Integer value1, Integer value2) {
            addCriterion("lkmid not between", value1, value2, "lkmid");
            return (Criteria) this;
        }

        public Criteria andLkmnameIsNull() {
            addCriterion("lkmName is null");
            return (Criteria) this;
        }

        public Criteria andLkmnameIsNotNull() {
            addCriterion("lkmName is not null");
            return (Criteria) this;
        }

        public Criteria andLkmnameEqualTo(String value) {
            addCriterion("lkmName =", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameNotEqualTo(String value) {
            addCriterion("lkmName <>", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameGreaterThan(String value) {
            addCriterion("lkmName >", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameGreaterThanOrEqualTo(String value) {
            addCriterion("lkmName >=", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameLessThan(String value) {
            addCriterion("lkmName <", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameLessThanOrEqualTo(String value) {
            addCriterion("lkmName <=", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameLike(String value) {
            addCriterion("lkmName like", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameNotLike(String value) {
            addCriterion("lkmName not like", value, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameIn(List<String> values) {
            addCriterion("lkmName in", values, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameNotIn(List<String> values) {
            addCriterion("lkmName not in", values, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameBetween(String value1, String value2) {
            addCriterion("lkmName between", value1, value2, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmnameNotBetween(String value1, String value2) {
            addCriterion("lkmName not between", value1, value2, "lkmname");
            return (Criteria) this;
        }

        public Criteria andLkmphoneIsNull() {
            addCriterion("lkmPhone is null");
            return (Criteria) this;
        }

        public Criteria andLkmphoneIsNotNull() {
            addCriterion("lkmPhone is not null");
            return (Criteria) this;
        }

        public Criteria andLkmphoneEqualTo(String value) {
            addCriterion("lkmPhone =", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneNotEqualTo(String value) {
            addCriterion("lkmPhone <>", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneGreaterThan(String value) {
            addCriterion("lkmPhone >", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneGreaterThanOrEqualTo(String value) {
            addCriterion("lkmPhone >=", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneLessThan(String value) {
            addCriterion("lkmPhone <", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneLessThanOrEqualTo(String value) {
            addCriterion("lkmPhone <=", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneLike(String value) {
            addCriterion("lkmPhone like", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneNotLike(String value) {
            addCriterion("lkmPhone not like", value, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneIn(List<String> values) {
            addCriterion("lkmPhone in", values, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneNotIn(List<String> values) {
            addCriterion("lkmPhone not in", values, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneBetween(String value1, String value2) {
            addCriterion("lkmPhone between", value1, value2, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmphoneNotBetween(String value1, String value2) {
            addCriterion("lkmPhone not between", value1, value2, "lkmphone");
            return (Criteria) this;
        }

        public Criteria andLkmsexIsNull() {
            addCriterion("lkmSex is null");
            return (Criteria) this;
        }

        public Criteria andLkmsexIsNotNull() {
            addCriterion("lkmSex is not null");
            return (Criteria) this;
        }

        public Criteria andLkmsexEqualTo(String value) {
            addCriterion("lkmSex =", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexNotEqualTo(String value) {
            addCriterion("lkmSex <>", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexGreaterThan(String value) {
            addCriterion("lkmSex >", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexGreaterThanOrEqualTo(String value) {
            addCriterion("lkmSex >=", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexLessThan(String value) {
            addCriterion("lkmSex <", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexLessThanOrEqualTo(String value) {
            addCriterion("lkmSex <=", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexLike(String value) {
            addCriterion("lkmSex like", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexNotLike(String value) {
            addCriterion("lkmSex not like", value, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexIn(List<String> values) {
            addCriterion("lkmSex in", values, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexNotIn(List<String> values) {
            addCriterion("lkmSex not in", values, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexBetween(String value1, String value2) {
            addCriterion("lkmSex between", value1, value2, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andLkmsexNotBetween(String value1, String value2) {
            addCriterion("lkmSex not between", value1, value2, "lkmsex");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
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