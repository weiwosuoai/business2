package com.allen.pojo.vo;

import com.allen.pojo.Order;
import com.allen.pojo.Product;

/**
 * Created by Allen on 2017/9/26.
 */
public class OrderVo extends Order {

	private Product product;
	private String createTimeStr;
	private String payTimeStr;

	public String getPayTimeStr() {
		return payTimeStr;
	}

	public void setPayTimeStr(String payTimeStr) {
		this.payTimeStr = payTimeStr;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}
