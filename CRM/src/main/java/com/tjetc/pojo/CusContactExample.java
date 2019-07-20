package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class CusContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CusContactExample() {
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

        public Criteria andConidIsNull() {
            addCriterion("conid is null");
            return (Criteria) this;
        }

        public Criteria andConidIsNotNull() {
            addCriterion("conid is not null");
            return (Criteria) this;
        }

        public Criteria andConidEqualTo(Integer value) {
            addCriterion("conid =", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidNotEqualTo(Integer value) {
            addCriterion("conid <>", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidGreaterThan(Integer value) {
            addCriterion("conid >", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidGreaterThanOrEqualTo(Integer value) {
            addCriterion("conid >=", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidLessThan(Integer value) {
            addCriterion("conid <", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidLessThanOrEqualTo(Integer value) {
            addCriterion("conid <=", value, "conid");
            return (Criteria) this;
        }

        public Criteria andConidIn(List<Integer> values) {
            addCriterion("conid in", values, "conid");
            return (Criteria) this;
        }

        public Criteria andConidNotIn(List<Integer> values) {
            addCriterion("conid not in", values, "conid");
            return (Criteria) this;
        }

        public Criteria andConidBetween(Integer value1, Integer value2) {
            addCriterion("conid between", value1, value2, "conid");
            return (Criteria) this;
        }

        public Criteria andConidNotBetween(Integer value1, Integer value2) {
            addCriterion("conid not between", value1, value2, "conid");
            return (Criteria) this;
        }

        public Criteria andCondateIsNull() {
            addCriterion("condate is null");
            return (Criteria) this;
        }

        public Criteria andCondateIsNotNull() {
            addCriterion("condate is not null");
            return (Criteria) this;
        }

        public Criteria andCondateEqualTo(String value) {
            addCriterion("condate =", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateNotEqualTo(String value) {
            addCriterion("condate <>", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateGreaterThan(String value) {
            addCriterion("condate >", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateGreaterThanOrEqualTo(String value) {
            addCriterion("condate >=", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateLessThan(String value) {
            addCriterion("condate <", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateLessThanOrEqualTo(String value) {
            addCriterion("condate <=", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateLike(String value) {
            addCriterion("condate like", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateNotLike(String value) {
            addCriterion("condate not like", value, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateIn(List<String> values) {
            addCriterion("condate in", values, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateNotIn(List<String> values) {
            addCriterion("condate not in", values, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateBetween(String value1, String value2) {
            addCriterion("condate between", value1, value2, "condate");
            return (Criteria) this;
        }

        public Criteria andCondateNotBetween(String value1, String value2) {
            addCriterion("condate not between", value1, value2, "condate");
            return (Criteria) this;
        }

        public Criteria andConaddrIsNull() {
            addCriterion("conAddr is null");
            return (Criteria) this;
        }

        public Criteria andConaddrIsNotNull() {
            addCriterion("conAddr is not null");
            return (Criteria) this;
        }

        public Criteria andConaddrEqualTo(String value) {
            addCriterion("conAddr =", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrNotEqualTo(String value) {
            addCriterion("conAddr <>", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrGreaterThan(String value) {
            addCriterion("conAddr >", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrGreaterThanOrEqualTo(String value) {
            addCriterion("conAddr >=", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrLessThan(String value) {
            addCriterion("conAddr <", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrLessThanOrEqualTo(String value) {
            addCriterion("conAddr <=", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrLike(String value) {
            addCriterion("conAddr like", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrNotLike(String value) {
            addCriterion("conAddr not like", value, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrIn(List<String> values) {
            addCriterion("conAddr in", values, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrNotIn(List<String> values) {
            addCriterion("conAddr not in", values, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrBetween(String value1, String value2) {
            addCriterion("conAddr between", value1, value2, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConaddrNotBetween(String value1, String value2) {
            addCriterion("conAddr not between", value1, value2, "conaddr");
            return (Criteria) this;
        }

        public Criteria andConifnoIsNull() {
            addCriterion("conIfno is null");
            return (Criteria) this;
        }

        public Criteria andConifnoIsNotNull() {
            addCriterion("conIfno is not null");
            return (Criteria) this;
        }

        public Criteria andConifnoEqualTo(String value) {
            addCriterion("conIfno =", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoNotEqualTo(String value) {
            addCriterion("conIfno <>", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoGreaterThan(String value) {
            addCriterion("conIfno >", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoGreaterThanOrEqualTo(String value) {
            addCriterion("conIfno >=", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoLessThan(String value) {
            addCriterion("conIfno <", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoLessThanOrEqualTo(String value) {
            addCriterion("conIfno <=", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoLike(String value) {
            addCriterion("conIfno like", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoNotLike(String value) {
            addCriterion("conIfno not like", value, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoIn(List<String> values) {
            addCriterion("conIfno in", values, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoNotIn(List<String> values) {
            addCriterion("conIfno not in", values, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoBetween(String value1, String value2) {
            addCriterion("conIfno between", value1, value2, "conifno");
            return (Criteria) this;
        }

        public Criteria andConifnoNotBetween(String value1, String value2) {
            addCriterion("conIfno not between", value1, value2, "conifno");
            return (Criteria) this;
        }

        public Criteria andConremarkIsNull() {
            addCriterion("conRemark is null");
            return (Criteria) this;
        }

        public Criteria andConremarkIsNotNull() {
            addCriterion("conRemark is not null");
            return (Criteria) this;
        }

        public Criteria andConremarkEqualTo(String value) {
            addCriterion("conRemark =", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkNotEqualTo(String value) {
            addCriterion("conRemark <>", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkGreaterThan(String value) {
            addCriterion("conRemark >", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkGreaterThanOrEqualTo(String value) {
            addCriterion("conRemark >=", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkLessThan(String value) {
            addCriterion("conRemark <", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkLessThanOrEqualTo(String value) {
            addCriterion("conRemark <=", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkLike(String value) {
            addCriterion("conRemark like", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkNotLike(String value) {
            addCriterion("conRemark not like", value, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkIn(List<String> values) {
            addCriterion("conRemark in", values, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkNotIn(List<String> values) {
            addCriterion("conRemark not in", values, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkBetween(String value1, String value2) {
            addCriterion("conRemark between", value1, value2, "conremark");
            return (Criteria) this;
        }

        public Criteria andConremarkNotBetween(String value1, String value2) {
            addCriterion("conRemark not between", value1, value2, "conremark");
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