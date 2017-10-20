package com.allen.service;

import java.util.List;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.LeftMenu;
import com.allen.pojo.Product;
import com.allen.pojo.vo.ProductVo;

public interface ProductService {

	BootstrapTableResult<ProductVo> findProductByPagination(int offset, int limit, Product product);

	Product findProductById(int productId);

	List<ProductVo> findAll();

	int deleteProductById(int productId);

	int addProduct(Product product);

	int editProductById(Product product);


}
