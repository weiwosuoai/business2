package com.allen.pojo.vo;

import com.allen.pojo.CompanyTransaction;
import com.allen.pojo.CompanyTransactionWithBLOBs;

public class CompanyTransactionVo extends CompanyTransactionWithBLOBs {

	private String createTimeStr;
	private String priceStart;
	private String priceEnd;

	public String getPriceStart() {
		return priceStart;
	}

	public void setPriceStart(String priceStart) {
		this.priceStart = priceStart;
	}

	public String getPriceEnd() {
		return priceEnd;
	}

	public void setPriceEnd(String priceEnd) {
		this.priceEnd = priceEnd;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}
