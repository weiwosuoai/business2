package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.pojo.ProductDescription;
import com.allen.pojo.ProductDescriptionWithBLOBs;


public interface ProductDescriptionService {

	BootstrapTableResult<ProductDescriptionWithBLOBs> findProductDescriptionByPagination(int offset, int limit, ProductDescription productDescription);

	ProductDescription findProductDescriptionById(int productDescriptionId);

	int deleteProductDescriptionById(int productDescriptionId);

	int addProductDescription(ProductDescriptionWithBLOBs productDescription);

	int editProductDescriptionById(ProductDescriptionWithBLOBs productDescription);


}
