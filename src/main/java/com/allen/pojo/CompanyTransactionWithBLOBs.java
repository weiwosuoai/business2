package com.allen.pojo;

public class CompanyTransactionWithBLOBs extends CompanyTransaction {

	private String  industryRequire; //行业要求
	
	private String addressRequire; //地址要求
	
	private String regCapitalRequire; //注册资金实缴要求

    public String getIndustryRequire() {
        return industryRequire;
    }

    public void setIndustryRequire(String industryRequire) {
        this.industryRequire = industryRequire == null ? null : industryRequire.trim();
    }

    public String getAddressRequire() {
        return addressRequire;
    }

    public void setAddressRequire(String addressRequire) {
        this.addressRequire = addressRequire == null ? null : addressRequire.trim();
    }

    public String getRegCapitalRequire() {
        return regCapitalRequire;
    }

    public void setRegCapitalRequire(String regCapitalRequire) {
        this.regCapitalRequire = regCapitalRequire == null ? null : regCapitalRequire.trim();
    }
}