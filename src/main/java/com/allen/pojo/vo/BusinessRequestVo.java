package com.allen.pojo.vo;

import com.allen.pojo.BusinessRequest;
import com.allen.pojo.Product;
import com.allen.pojo.ProductDescription;

public class BusinessRequestVo extends BusinessRequest {

	private String createTimeStr;

	private Product product;

	private ProductDescription description;


	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDescription getDescription() {
		return description;
	}

	public void setDescription(ProductDescription description) {
		this.description = description;
	}
}
