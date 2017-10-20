package com.allen.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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

        public Criteria andProductTitleIsNull() {
            addCriterion("product_title is null");
            return (Criteria) this;
        }

        public Criteria andProductTitleIsNotNull() {
            addCriterion("product_title is not null");
            return (Criteria) this;
        }

        public Criteria andProductTitleEqualTo(String value) {
            addCriterion("product_title =", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotEqualTo(String value) {
            addCriterion("product_title <>", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleGreaterThan(String value) {
            addCriterion("product_title >", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleGreaterThanOrEqualTo(String value) {
            addCriterion("product_title >=", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLessThan(String value) {
            addCriterion("product_title <", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLessThanOrEqualTo(String value) {
            addCriterion("product_title <=", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLike(String value) {
            addCriterion("product_title like", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotLike(String value) {
            addCriterion("product_title not like", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleIn(List<String> values) {
            addCriterion("product_title in", values, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotIn(List<String> values) {
            addCriterion("product_title not in", values, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleBetween(String value1, String value2) {
            addCriterion("product_title between", value1, value2, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotBetween(String value1, String value2) {
            addCriterion("product_title not between", value1, value2, "productTitle");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNull() {
            addCriterion("com_type is null");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNotNull() {
            addCriterion("com_type is not null");
            return (Criteria) this;
        }

        public Criteria andComTypeEqualTo(Integer value) {
            addCriterion("com_type =", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotEqualTo(Integer value) {
            addCriterion("com_type <>", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThan(Integer value) {
            addCriterion("com_type >", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_type >=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThan(Integer value) {
            addCriterion("com_type <", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThanOrEqualTo(Integer value) {
            addCriterion("com_type <=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeIn(List<Integer> values) {
            addCriterion("com_type in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotIn(List<Integer> values) {
            addCriterion("com_type not in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeBetween(Integer value1, Integer value2) {
            addCriterion("com_type between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("com_type not between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeIsNull() {
            addCriterion("sub_com_type is null");
            return (Criteria) this;
        }

        public Criteria andSubComTypeIsNotNull() {
            addCriterion("sub_com_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubComTypeEqualTo(Integer value) {
            addCriterion("sub_com_type =", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeNotEqualTo(Integer value) {
            addCriterion("sub_com_type <>", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeGreaterThan(Integer value) {
            addCriterion("sub_com_type >", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_com_type >=", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeLessThan(Integer value) {
            addCriterion("sub_com_type <", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sub_com_type <=", value, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeIn(List<Integer> values) {
            addCriterion("sub_com_type in", values, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeNotIn(List<Integer> values) {
            addCriterion("sub_com_type not in", values, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeBetween(Integer value1, Integer value2) {
            addCriterion("sub_com_type between", value1, value2, "subComType");
            return (Criteria) this;
        }

        public Criteria andSubComTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_com_type not between", value1, value2, "subComType");
            return (Criteria) this;
        }

        public Criteria andMonthSizeIsNull() {
            addCriterion("month_size is null");
            return (Criteria) this;
        }

        public Criteria andMonthSizeIsNotNull() {
            addCriterion("month_size is not null");
            return (Criteria) this;
        }

        public Criteria andMonthSizeEqualTo(Integer value) {
            addCriterion("month_size =", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeNotEqualTo(Integer value) {
            addCriterion("month_size <>", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeGreaterThan(Integer value) {
            addCriterion("month_size >", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_size >=", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeLessThan(Integer value) {
            addCriterion("month_size <", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeLessThanOrEqualTo(Integer value) {
            addCriterion("month_size <=", value, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeIn(List<Integer> values) {
            addCriterion("month_size in", values, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeNotIn(List<Integer> values) {
            addCriterion("month_size not in", values, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeBetween(Integer value1, Integer value2) {
            addCriterion("month_size between", value1, value2, "monthSize");
            return (Criteria) this;
        }

        public Criteria andMonthSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("month_size not between", value1, value2, "monthSize");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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