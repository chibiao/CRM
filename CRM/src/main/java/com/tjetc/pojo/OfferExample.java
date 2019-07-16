package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class OfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfferExample() {
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

        public Criteria andOfferIdIsNull() {
            addCriterion("offer_id is null");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNotNull() {
            addCriterion("offer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfferIdEqualTo(Integer value) {
            addCriterion("offer_id =", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotEqualTo(Integer value) {
            addCriterion("offer_id <>", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThan(Integer value) {
            addCriterion("offer_id >", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer_id >=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThan(Integer value) {
            addCriterion("offer_id <", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThanOrEqualTo(Integer value) {
            addCriterion("offer_id <=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdIn(List<Integer> values) {
            addCriterion("offer_id in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotIn(List<Integer> values) {
            addCriterion("offer_id not in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdBetween(Integer value1, Integer value2) {
            addCriterion("offer_id between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotBetween(Integer value1, Integer value2) {
            addCriterion("offer_id not between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andOfferStateIsNull() {
            addCriterion("offer_state is null");
            return (Criteria) this;
        }

        public Criteria andOfferStateIsNotNull() {
            addCriterion("offer_state is not null");
            return (Criteria) this;
        }

        public Criteria andOfferStateEqualTo(Integer value) {
            addCriterion("offer_state =", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateNotEqualTo(Integer value) {
            addCriterion("offer_state <>", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateGreaterThan(Integer value) {
            addCriterion("offer_state >", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer_state >=", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateLessThan(Integer value) {
            addCriterion("offer_state <", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateLessThanOrEqualTo(Integer value) {
            addCriterion("offer_state <=", value, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateIn(List<Integer> values) {
            addCriterion("offer_state in", values, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateNotIn(List<Integer> values) {
            addCriterion("offer_state not in", values, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateBetween(Integer value1, Integer value2) {
            addCriterion("offer_state between", value1, value2, "offerState");
            return (Criteria) this;
        }

        public Criteria andOfferStateNotBetween(Integer value1, Integer value2) {
            addCriterion("offer_state not between", value1, value2, "offerState");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andQuodationIsNull() {
            addCriterion("quodation is null");
            return (Criteria) this;
        }

        public Criteria andQuodationIsNotNull() {
            addCriterion("quodation is not null");
            return (Criteria) this;
        }

        public Criteria andQuodationEqualTo(Double value) {
            addCriterion("quodation =", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationNotEqualTo(Double value) {
            addCriterion("quodation <>", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationGreaterThan(Double value) {
            addCriterion("quodation >", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationGreaterThanOrEqualTo(Double value) {
            addCriterion("quodation >=", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationLessThan(Double value) {
            addCriterion("quodation <", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationLessThanOrEqualTo(Double value) {
            addCriterion("quodation <=", value, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationIn(List<Double> values) {
            addCriterion("quodation in", values, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationNotIn(List<Double> values) {
            addCriterion("quodation not in", values, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationBetween(Double value1, Double value2) {
            addCriterion("quodation between", value1, value2, "quodation");
            return (Criteria) this;
        }

        public Criteria andQuodationNotBetween(Double value1, Double value2) {
            addCriterion("quodation not between", value1, value2, "quodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationIsNull() {
            addCriterion("impl_quodation is null");
            return (Criteria) this;
        }

        public Criteria andImplQuodationIsNotNull() {
            addCriterion("impl_quodation is not null");
            return (Criteria) this;
        }

        public Criteria andImplQuodationEqualTo(Double value) {
            addCriterion("impl_quodation =", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationNotEqualTo(Double value) {
            addCriterion("impl_quodation <>", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationGreaterThan(Double value) {
            addCriterion("impl_quodation >", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationGreaterThanOrEqualTo(Double value) {
            addCriterion("impl_quodation >=", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationLessThan(Double value) {
            addCriterion("impl_quodation <", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationLessThanOrEqualTo(Double value) {
            addCriterion("impl_quodation <=", value, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationIn(List<Double> values) {
            addCriterion("impl_quodation in", values, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationNotIn(List<Double> values) {
            addCriterion("impl_quodation not in", values, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationBetween(Double value1, Double value2) {
            addCriterion("impl_quodation between", value1, value2, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andImplQuodationNotBetween(Double value1, Double value2) {
            addCriterion("impl_quodation not between", value1, value2, "implQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationIsNull() {
            addCriterion("serv_quodation is null");
            return (Criteria) this;
        }

        public Criteria andServQuodationIsNotNull() {
            addCriterion("serv_quodation is not null");
            return (Criteria) this;
        }

        public Criteria andServQuodationEqualTo(Double value) {
            addCriterion("serv_quodation =", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationNotEqualTo(Double value) {
            addCriterion("serv_quodation <>", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationGreaterThan(Double value) {
            addCriterion("serv_quodation >", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationGreaterThanOrEqualTo(Double value) {
            addCriterion("serv_quodation >=", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationLessThan(Double value) {
            addCriterion("serv_quodation <", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationLessThanOrEqualTo(Double value) {
            addCriterion("serv_quodation <=", value, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationIn(List<Double> values) {
            addCriterion("serv_quodation in", values, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationNotIn(List<Double> values) {
            addCriterion("serv_quodation not in", values, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationBetween(Double value1, Double value2) {
            addCriterion("serv_quodation between", value1, value2, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andServQuodationNotBetween(Double value1, Double value2) {
            addCriterion("serv_quodation not between", value1, value2, "servQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationIsNull() {
            addCriterion("spec_quodation is null");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationIsNotNull() {
            addCriterion("spec_quodation is not null");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationEqualTo(Double value) {
            addCriterion("spec_quodation =", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationNotEqualTo(Double value) {
            addCriterion("spec_quodation <>", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationGreaterThan(Double value) {
            addCriterion("spec_quodation >", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationGreaterThanOrEqualTo(Double value) {
            addCriterion("spec_quodation >=", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationLessThan(Double value) {
            addCriterion("spec_quodation <", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationLessThanOrEqualTo(Double value) {
            addCriterion("spec_quodation <=", value, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationIn(List<Double> values) {
            addCriterion("spec_quodation in", values, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationNotIn(List<Double> values) {
            addCriterion("spec_quodation not in", values, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationBetween(Double value1, Double value2) {
            addCriterion("spec_quodation between", value1, value2, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andSpecQuodationNotBetween(Double value1, Double value2) {
            addCriterion("spec_quodation not between", value1, value2, "specQuodation");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossIsNull() {
            addCriterion("profit_or_loss is null");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossIsNotNull() {
            addCriterion("profit_or_loss is not null");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossEqualTo(Double value) {
            addCriterion("profit_or_loss =", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossNotEqualTo(Double value) {
            addCriterion("profit_or_loss <>", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossGreaterThan(Double value) {
            addCriterion("profit_or_loss >", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossGreaterThanOrEqualTo(Double value) {
            addCriterion("profit_or_loss >=", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossLessThan(Double value) {
            addCriterion("profit_or_loss <", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossLessThanOrEqualTo(Double value) {
            addCriterion("profit_or_loss <=", value, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossIn(List<Double> values) {
            addCriterion("profit_or_loss in", values, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossNotIn(List<Double> values) {
            addCriterion("profit_or_loss not in", values, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossBetween(Double value1, Double value2) {
            addCriterion("profit_or_loss between", value1, value2, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andProfitOrLossNotBetween(Double value1, Double value2) {
            addCriterion("profit_or_loss not between", value1, value2, "profitOrLoss");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Double value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Double value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Double value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Double value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Double value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Double> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Double> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Double value1, Double value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Double value1, Double value2) {
            addCriterion("total not between", value1, value2, "total");
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