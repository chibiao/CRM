package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CusLostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CusLostExample() {
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

        public Criteria andLostidIsNull() {
            addCriterion("lostid is null");
            return (Criteria) this;
        }

        public Criteria andLostidIsNotNull() {
            addCriterion("lostid is not null");
            return (Criteria) this;
        }

        public Criteria andLostidEqualTo(Integer value) {
            addCriterion("lostid =", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidNotEqualTo(Integer value) {
            addCriterion("lostid <>", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidGreaterThan(Integer value) {
            addCriterion("lostid >", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lostid >=", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidLessThan(Integer value) {
            addCriterion("lostid <", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidLessThanOrEqualTo(Integer value) {
            addCriterion("lostid <=", value, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidIn(List<Integer> values) {
            addCriterion("lostid in", values, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidNotIn(List<Integer> values) {
            addCriterion("lostid not in", values, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidBetween(Integer value1, Integer value2) {
            addCriterion("lostid between", value1, value2, "lostid");
            return (Criteria) this;
        }

        public Criteria andLostidNotBetween(Integer value1, Integer value2) {
            addCriterion("lostid not between", value1, value2, "lostid");
            return (Criteria) this;
        }

        public Criteria andLastordertimeIsNull() {
            addCriterion("lastOrderTime is null");
            return (Criteria) this;
        }

        public Criteria andLastordertimeIsNotNull() {
            addCriterion("lastOrderTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastordertimeEqualTo(String value) {
            addCriterion("lastOrderTime =", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeNotEqualTo(String value) {
            addCriterion("lastOrderTime <>", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeGreaterThan(String value) {
            addCriterion("lastOrderTime >", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeGreaterThanOrEqualTo(String value) {
            addCriterion("lastOrderTime >=", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeLessThan(String value) {
            addCriterion("lastOrderTime <", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeLessThanOrEqualTo(String value) {
            addCriterion("lastOrderTime <=", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeLike(String value) {
            addCriterion("lastOrderTime like", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeNotLike(String value) {
            addCriterion("lastOrderTime not like", value, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeIn(List<String> values) {
            addCriterion("lastOrderTime in", values, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeNotIn(List<String> values) {
            addCriterion("lastOrderTime not in", values, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeBetween(String value1, String value2) {
            addCriterion("lastOrderTime between", value1, value2, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLastordertimeNotBetween(String value1, String value2) {
            addCriterion("lastOrderTime not between", value1, value2, "lastordertime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lastTime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lastTime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lastTime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lastTime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lastTime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastTime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lastTime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lastTime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lastTime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lastTime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lastTime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lastTime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLastreasonIsNull() {
            addCriterion("lastReason is null");
            return (Criteria) this;
        }

        public Criteria andLastreasonIsNotNull() {
            addCriterion("lastReason is not null");
            return (Criteria) this;
        }

        public Criteria andLastreasonEqualTo(String value) {
            addCriterion("lastReason =", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonNotEqualTo(String value) {
            addCriterion("lastReason <>", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonGreaterThan(String value) {
            addCriterion("lastReason >", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonGreaterThanOrEqualTo(String value) {
            addCriterion("lastReason >=", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonLessThan(String value) {
            addCriterion("lastReason <", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonLessThanOrEqualTo(String value) {
            addCriterion("lastReason <=", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonLike(String value) {
            addCriterion("lastReason like", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonNotLike(String value) {
            addCriterion("lastReason not like", value, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonIn(List<String> values) {
            addCriterion("lastReason in", values, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonNotIn(List<String> values) {
            addCriterion("lastReason not in", values, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonBetween(String value1, String value2) {
            addCriterion("lastReason between", value1, value2, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastreasonNotBetween(String value1, String value2) {
            addCriterion("lastReason not between", value1, value2, "lastreason");
            return (Criteria) this;
        }

        public Criteria andLastdelayIsNull() {
            addCriterion("lastDelay is null");
            return (Criteria) this;
        }

        public Criteria andLastdelayIsNotNull() {
            addCriterion("lastDelay is not null");
            return (Criteria) this;
        }

        public Criteria andLastdelayEqualTo(String value) {
            addCriterion("lastDelay =", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayNotEqualTo(String value) {
            addCriterion("lastDelay <>", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayGreaterThan(String value) {
            addCriterion("lastDelay >", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayGreaterThanOrEqualTo(String value) {
            addCriterion("lastDelay >=", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayLessThan(String value) {
            addCriterion("lastDelay <", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayLessThanOrEqualTo(String value) {
            addCriterion("lastDelay <=", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayLike(String value) {
            addCriterion("lastDelay like", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayNotLike(String value) {
            addCriterion("lastDelay not like", value, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayIn(List<String> values) {
            addCriterion("lastDelay in", values, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayNotIn(List<String> values) {
            addCriterion("lastDelay not in", values, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayBetween(String value1, String value2) {
            addCriterion("lastDelay between", value1, value2, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLastdelayNotBetween(String value1, String value2) {
            addCriterion("lastDelay not between", value1, value2, "lastdelay");
            return (Criteria) this;
        }

        public Criteria andLaststatusIsNull() {
            addCriterion("lastStatus is null");
            return (Criteria) this;
        }

        public Criteria andLaststatusIsNotNull() {
            addCriterion("lastStatus is not null");
            return (Criteria) this;
        }

        public Criteria andLaststatusEqualTo(Integer value) {
            addCriterion("lastStatus =", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusNotEqualTo(Integer value) {
            addCriterion("lastStatus <>", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusGreaterThan(Integer value) {
            addCriterion("lastStatus >", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastStatus >=", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusLessThan(Integer value) {
            addCriterion("lastStatus <", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusLessThanOrEqualTo(Integer value) {
            addCriterion("lastStatus <=", value, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusIn(List<Integer> values) {
            addCriterion("lastStatus in", values, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusNotIn(List<Integer> values) {
            addCriterion("lastStatus not in", values, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusBetween(Integer value1, Integer value2) {
            addCriterion("lastStatus between", value1, value2, "laststatus");
            return (Criteria) this;
        }

        public Criteria andLaststatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lastStatus not between", value1, value2, "laststatus");
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

        public Criteria andCmidIsNull() {
            addCriterion("cmid is null");
            return (Criteria) this;
        }

        public Criteria andCmidIsNotNull() {
            addCriterion("cmid is not null");
            return (Criteria) this;
        }

        public Criteria andCmidEqualTo(Integer value) {
            addCriterion("cmid =", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotEqualTo(Integer value) {
            addCriterion("cmid <>", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidGreaterThan(Integer value) {
            addCriterion("cmid >", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmid >=", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidLessThan(Integer value) {
            addCriterion("cmid <", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidLessThanOrEqualTo(Integer value) {
            addCriterion("cmid <=", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidIn(List<Integer> values) {
            addCriterion("cmid in", values, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotIn(List<Integer> values) {
            addCriterion("cmid not in", values, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidBetween(Integer value1, Integer value2) {
            addCriterion("cmid between", value1, value2, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotBetween(Integer value1, Integer value2) {
            addCriterion("cmid not between", value1, value2, "cmid");
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