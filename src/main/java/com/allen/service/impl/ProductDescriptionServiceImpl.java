package com.allen.service.impl;

import java.util.List;

import com.allen.dao.*;
import com.allen.pojo.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.service.ProductDescriptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

	private static final Log logger = LogFactory.getLog(ProductDescriptionServiceImpl.class);

	@Autowired
	private ProductDescriptionMapper productDescriptionMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public BootstrapTableResult<ProductDescriptionWithBLOBs> findProductDescriptionByPagination(int offset, int limit, ProductDescription productDescription) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		ProductDescriptionExample example = new ProductDescriptionExample();
		example.setOrderByClause("desc_id desc");

		ProductDescriptionExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(productDescription.getDescName())) {
			criteria.andDescNameLike("%" + productDescription.getDescName() + "%");
		}

//		if (productDescription.getRoleId() != null) {
//			criteria.andRoleIdEqualTo(productDescription.getRoleId());
//		}

		List<ProductDescriptionWithBLOBs> list = productDescriptionMapper.selectByExampleWithBLOBs(example);

//		for (ProductDescriptionWithBLOBs vo : list) {
//
//			Product product = productMapper.selectByPrimaryKey(vo.getProductId());
//			if (product != null) {
//				vo.setDescName(product.getProductName());
//			}
//		}

		PageInfo<ProductDescriptionWithBLOBs> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<ProductDescriptionWithBLOBs> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public ProductDescription findProductDescriptionById(int productDescriptionId) {
		return productDescriptionMapper.selectByPrimaryKey(productDescriptionId);
	}

	@Override
	public int deleteProductDescriptionById(int productDescriptionId) {
		return productDescriptionMapper.deleteByPrimaryKey(productDescriptionId);
	}

	@Override
	public int addProductDescription(ProductDescriptionWithBLOBs productDescription) {
		try {
			return productDescriptionMapper.insert(productDescription);
		} catch (Exception e) {
			logger.error("", e);
		}
		return 0;
	}

	@Override
	public int editProductDescriptionById(ProductDescriptionWithBLOBs productDescription) {
		return productDescriptionMapper.updateByPrimaryKeySelective(productDescription);
	}


}
