package com.allen.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CompanyTransactionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyTransactionExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTransIdIsNull() {
            addCriterion("trans_id is null");
            return (Criteria) this;
        }

        public Criteria andTransIdIsNotNull() {
            addCriterion("trans_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransIdEqualTo(Integer value) {
            addCriterion("trans_id =", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotEqualTo(Integer value) {
            addCriterion("trans_id <>", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThan(Integer value) {
            addCriterion("trans_id >", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_id >=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThan(Integer value) {
            addCriterion("trans_id <", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThanOrEqualTo(Integer value) {
            addCriterion("trans_id <=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdIn(List<Integer> values) {
            addCriterion("trans_id in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotIn(List<Integer> values) {
            addCriterion("trans_id not in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdBetween(Integer value1, Integer value2) {
            addCriterion("trans_id between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_id not between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNull() {
            addCriterion("trans_type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(Integer value) {
            addCriterion("trans_type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(Integer value) {
            addCriterion("trans_type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(Integer value) {
            addCriterion("trans_type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(Integer value) {
            addCriterion("trans_type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trans_type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<Integer> values) {
            addCriterion("trans_type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<Integer> values) {
            addCriterion("trans_type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(Integer value1, Integer value2) {
            addCriterion("trans_type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_type not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLicenseImageIsNull() {
            addCriterion("license_image is null");
            return (Criteria) this;
        }

        public Criteria andLicenseImageIsNotNull() {
            addCriterion("license_image is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseImageEqualTo(String value) {
            addCriterion("license_image =", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageNotEqualTo(String value) {
            addCriterion("license_image <>", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageGreaterThan(String value) {
            addCriterion("license_image >", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageGreaterThanOrEqualTo(String value) {
            addCriterion("license_image >=", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageLessThan(String value) {
            addCriterion("license_image <", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageLessThanOrEqualTo(String value) {
            addCriterion("license_image <=", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageLike(String value) {
            addCriterion("license_image like", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageNotLike(String value) {
            addCriterion("license_image not like", value, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageIn(List<String> values) {
            addCriterion("license_image in", values, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageNotIn(List<String> values) {
            addCriterion("license_image not in", values, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageBetween(String value1, String value2) {
            addCriterion("license_image between", value1, value2, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andLicenseImageNotBetween(String value1, String value2) {
            addCriterion("license_image not between", value1, value2, "licenseImage");
            return (Criteria) this;
        }

        public Criteria andDebtIsNull() {
            addCriterion("debt is null");
            return (Criteria) this;
        }

        public Criteria andDebtIsNotNull() {
            addCriterion("debt is not null");
            return (Criteria) this;
        }

        public Criteria andDebtEqualTo(Integer value) {
            addCriterion("debt =", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotEqualTo(Integer value) {
            addCriterion("debt <>", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtGreaterThan(Integer value) {
            addCriterion("debt >", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtGreaterThanOrEqualTo(Integer value) {
            addCriterion("debt >=", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtLessThan(Integer value) {
            addCriterion("debt <", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtLessThanOrEqualTo(Integer value) {
            addCriterion("debt <=", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtIn(List<Integer> values) {
            addCriterion("debt in", values, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotIn(List<Integer> values) {
            addCriterion("debt not in", values, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtBetween(Integer value1, Integer value2) {
            addCriterion("debt between", value1, value2, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotBetween(Integer value1, Integer value2) {
            addCriterion("debt not between", value1, value2, "debt");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIsNull() {
            addCriterion("finance_status is null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIsNotNull() {
            addCriterion("finance_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusEqualTo(Integer value) {
            addCriterion("finance_status =", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotEqualTo(Integer value) {
            addCriterion("finance_status <>", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThan(Integer value) {
            addCriterion("finance_status >", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_status >=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThan(Integer value) {
            addCriterion("finance_status <", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("finance_status <=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIn(List<Integer> values) {
            addCriterion("finance_status in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotIn(List<Integer> values) {
            addCriterion("finance_status not in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("finance_status between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_status not between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andPermitIsNull() {
            addCriterion("permit is null");
            return (Criteria) this;
        }

        public Criteria andPermitIsNotNull() {
            addCriterion("permit is not null");
            return (Criteria) this;
        }

        public Criteria andPermitEqualTo(Integer value) {
            addCriterion("permit =", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotEqualTo(Integer value) {
            addCriterion("permit <>", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThan(Integer value) {
            addCriterion("permit >", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThanOrEqualTo(Integer value) {
            addCriterion("permit >=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThan(Integer value) {
            addCriterion("permit <", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThanOrEqualTo(Integer value) {
            addCriterion("permit <=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitIn(List<Integer> values) {
            addCriterion("permit in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotIn(List<Integer> values) {
            addCriterion("permit not in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitBetween(Integer value1, Integer value2) {
            addCriterion("permit between", value1, value2, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotBetween(Integer value1, Integer value2) {
            addCriterion("permit not between", value1, value2, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitImageIsNull() {
            addCriterion("permit_image is null");
            return (Criteria) this;
        }

        public Criteria andPermitImageIsNotNull() {
            addCriterion("permit_image is not null");
            return (Criteria) this;
        }

        public Criteria andPermitImageEqualTo(String value) {
            addCriterion("permit_image =", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageNotEqualTo(String value) {
            addCriterion("permit_image <>", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageGreaterThan(String value) {
            addCriterion("permit_image >", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageGreaterThanOrEqualTo(String value) {
            addCriterion("permit_image >=", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageLessThan(String value) {
            addCriterion("permit_image <", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageLessThanOrEqualTo(String value) {
            addCriterion("permit_image <=", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageLike(String value) {
            addCriterion("permit_image like", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageNotLike(String value) {
            addCriterion("permit_image not like", value, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageIn(List<String> values) {
            addCriterion("permit_image in", values, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageNotIn(List<String> values) {
            addCriterion("permit_image not in", values, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageBetween(String value1, String value2) {
            addCriterion("permit_image between", value1, value2, "permitImage");
            return (Criteria) this;
        }

        public Criteria andPermitImageNotBetween(String value1, String value2) {
            addCriterion("permit_image not between", value1, value2, "permitImage");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andBargainIsNull() {
            addCriterion("bargain is null");
            return (Criteria) this;
        }

        public Criteria andBargainIsNotNull() {
            addCriterion("bargain is not null");
            return (Criteria) this;
        }

        public Criteria andBargainEqualTo(Integer value) {
            addCriterion("bargain =", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotEqualTo(Integer value) {
            addCriterion("bargain <>", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainGreaterThan(Integer value) {
            addCriterion("bargain >", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("bargain >=", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainLessThan(Integer value) {
            addCriterion("bargain <", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainLessThanOrEqualTo(Integer value) {
            addCriterion("bargain <=", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainIn(List<Integer> values) {
            addCriterion("bargain in", values, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotIn(List<Integer> values) {
            addCriterion("bargain not in", values, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainBetween(Integer value1, Integer value2) {
            addCriterion("bargain between", value1, value2, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("bargain not between", value1, value2, "bargain");
            return (Criteria) this;
        }

        public Criteria andRegDurationIsNull() {
            addCriterion("reg_duration is null");
            return (Criteria) this;
        }

        public Criteria andRegDurationIsNotNull() {
            addCriterion("reg_duration is not null");
            return (Criteria) this;
        }

        public Criteria andRegDurationEqualTo(Integer value) {
            addCriterion("reg_duration =", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationNotEqualTo(Integer value) {
            addCriterion("reg_duration <>", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationGreaterThan(Integer value) {
            addCriterion("reg_duration >", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_duration >=", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationLessThan(Integer value) {
            addCriterion("reg_duration <", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationLessThanOrEqualTo(Integer value) {
            addCriterion("reg_duration <=", value, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationIn(List<Integer> values) {
            addCriterion("reg_duration in", values, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationNotIn(List<Integer> values) {
            addCriterion("reg_duration not in", values, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationBetween(Integer value1, Integer value2) {
            addCriterion("reg_duration between", value1, value2, "regDuration");
            return (Criteria) this;
        }

        public Criteria andRegDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_duration not between", value1, value2, "regDuration");
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

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNull() {
            addCriterion("valid_code is null");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNotNull() {
            addCriterion("valid_code is not null");
            return (Criteria) this;
        }

        public Criteria andValidCodeEqualTo(String value) {
            addCriterion("valid_code =", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotEqualTo(String value) {
            addCriterion("valid_code <>", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThan(String value) {
            addCriterion("valid_code >", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("valid_code >=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThan(String value) {
            addCriterion("valid_code <", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThanOrEqualTo(String value) {
            addCriterion("valid_code <=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLike(String value) {
            addCriterion("valid_code like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotLike(String value) {
            addCriterion("valid_code not like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeIn(List<String> values) {
            addCriterion("valid_code in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotIn(List<String> values) {
            addCriterion("valid_code not in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeBetween(String value1, String value2) {
            addCriterion("valid_code between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotBetween(String value1, String value2) {
            addCriterion("valid_code not between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidDateEndIsNull() {
            addCriterion("valid_date_end is null");
            return (Criteria) this;
        }

        public Criteria andValidDateEndIsNotNull() {
            addCriterion("valid_date_end is not null");
            return (Criteria) this;
        }

        public Criteria andValidDateEndEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date_end =", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date_end <>", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndGreaterThan(Date value) {
            addCriterionForJDBCDate("valid_date_end >", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date_end >=", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndLessThan(Date value) {
            addCriterionForJDBCDate("valid_date_end <", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("valid_date_end <=", value, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date_end in", values, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("valid_date_end not in", values, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date_end between", value1, value2, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andValidDateEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("valid_date_end not between", value1, value2, "validDateEnd");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIsNull() {
            addCriterion("accept_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIsNotNull() {
            addCriterion("accept_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdEqualTo(Integer value) {
            addCriterion("accept_user_id =", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotEqualTo(Integer value) {
            addCriterion("accept_user_id <>", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdGreaterThan(Integer value) {
            addCriterion("accept_user_id >", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("accept_user_id >=", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdLessThan(Integer value) {
            addCriterion("accept_user_id <", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("accept_user_id <=", value, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdIn(List<Integer> values) {
            addCriterion("accept_user_id in", values, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotIn(List<Integer> values) {
            addCriterion("accept_user_id not in", values, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdBetween(Integer value1, Integer value2) {
            addCriterion("accept_user_id between", value1, value2, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("accept_user_id not between", value1, value2, "acceptUserId");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIsNull() {
            addCriterion("accept_user_name is null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIsNotNull() {
            addCriterion("accept_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameEqualTo(String value) {
            addCriterion("accept_user_name =", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotEqualTo(String value) {
            addCriterion("accept_user_name <>", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameGreaterThan(String value) {
            addCriterion("accept_user_name >", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("accept_user_name >=", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLessThan(String value) {
            addCriterion("accept_user_name <", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLessThanOrEqualTo(String value) {
            addCriterion("accept_user_name <=", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameLike(String value) {
            addCriterion("accept_user_name like", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotLike(String value) {
            addCriterion("accept_user_name not like", value, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameIn(List<String> values) {
            addCriterion("accept_user_name in", values, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotIn(List<String> values) {
            addCriterion("accept_user_name not in", values, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameBetween(String value1, String value2) {
            addCriterion("accept_user_name between", value1, value2, "acceptUserName");
            return (Criteria) this;
        }

        public Criteria andAcceptUserNameNotBetween(String value1, String value2) {
            addCriterion("accept_user_name not between", value1, value2, "acceptUserName");
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