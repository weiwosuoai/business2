package com.allen.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProductDescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDescriptionExample() {
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

        public Criteria andDescIdIsNull() {
            addCriterion("desc_Id is null");
            return (Criteria) this;
        }

        public Criteria andDescIdIsNotNull() {
            addCriterion("desc_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDescIdEqualTo(Integer value) {
            addCriterion("desc_Id =", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdNotEqualTo(Integer value) {
            addCriterion("desc_Id <>", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdGreaterThan(Integer value) {
            addCriterion("desc_Id >", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("desc_Id >=", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdLessThan(Integer value) {
            addCriterion("desc_Id <", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdLessThanOrEqualTo(Integer value) {
            addCriterion("desc_Id <=", value, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdIn(List<Integer> values) {
            addCriterion("desc_Id in", values, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdNotIn(List<Integer> values) {
            addCriterion("desc_Id not in", values, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdBetween(Integer value1, Integer value2) {
            addCriterion("desc_Id between", value1, value2, "descId");
            return (Criteria) this;
        }

        public Criteria andDescIdNotBetween(Integer value1, Integer value2) {
            addCriterion("desc_Id not between", value1, value2, "descId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_Id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_Id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_Id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_Id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_Id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_Id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_Id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_Id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_Id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_Id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_Id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_Id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andDescNameIsNull() {
            addCriterion("desc_name is null");
            return (Criteria) this;
        }

        public Criteria andDescNameIsNotNull() {
            addCriterion("desc_name is not null");
            return (Criteria) this;
        }

        public Criteria andDescNameEqualTo(String value) {
            addCriterion("desc_name =", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameNotEqualTo(String value) {
            addCriterion("desc_name <>", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameGreaterThan(String value) {
            addCriterion("desc_name >", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameGreaterThanOrEqualTo(String value) {
            addCriterion("desc_name >=", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameLessThan(String value) {
            addCriterion("desc_name <", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameLessThanOrEqualTo(String value) {
            addCriterion("desc_name <=", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameLike(String value) {
            addCriterion("desc_name like", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameNotLike(String value) {
            addCriterion("desc_name not like", value, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameIn(List<String> values) {
            addCriterion("desc_name in", values, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameNotIn(List<String> values) {
            addCriterion("desc_name not in", values, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameBetween(String value1, String value2) {
            addCriterion("desc_name between", value1, value2, "descName");
            return (Criteria) this;
        }

        public Criteria andDescNameNotBetween(String value1, String value2) {
            addCriterion("desc_name not between", value1, value2, "descName");
            return (Criteria) this;
        }

        public Criteria andFlowImageIsNull() {
            addCriterion("flow_Image is null");
            return (Criteria) this;
        }

        public Criteria andFlowImageIsNotNull() {
            addCriterion("flow_Image is not null");
            return (Criteria) this;
        }

        public Criteria andFlowImageEqualTo(String value) {
            addCriterion("flow_Image =", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageNotEqualTo(String value) {
            addCriterion("flow_Image <>", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageGreaterThan(String value) {
            addCriterion("flow_Image >", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageGreaterThanOrEqualTo(String value) {
            addCriterion("flow_Image >=", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageLessThan(String value) {
            addCriterion("flow_Image <", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageLessThanOrEqualTo(String value) {
            addCriterion("flow_Image <=", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageLike(String value) {
            addCriterion("flow_Image like", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageNotLike(String value) {
            addCriterion("flow_Image not like", value, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageIn(List<String> values) {
            addCriterion("flow_Image in", values, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageNotIn(List<String> values) {
            addCriterion("flow_Image not in", values, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageBetween(String value1, String value2) {
            addCriterion("flow_Image between", value1, value2, "flowImage");
            return (Criteria) this;
        }

        public Criteria andFlowImageNotBetween(String value1, String value2) {
            addCriterion("flow_Image not between", value1, value2, "flowImage");
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