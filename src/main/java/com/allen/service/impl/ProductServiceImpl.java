package com.allen.service.impl;

import java.text.SimpleDateFormat;

import java.util.List;

import com.allen.dao.ProductMapper;
import com.allen.pojo.Product;
import com.allen.pojo.ProductExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.LeftMenu;
import com.allen.dao.RoleMapper;
import com.allen.pojo.vo.ProductVo;
import com.allen.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ProductServiceImpl implements ProductService{

	private static final Log logger = LogFactory.getLog(ProductServiceImpl.class);

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public BootstrapTableResult<ProductVo> findProductByPagination(int offset, int limit, Product product) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		ProductExample example = new ProductExample();
		example.setOrderByClause("create_time desc");

		ProductExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(product.getProductName())) {
			criteria.andProductNameLike("%" + product.getProductName() + "%");

		}

		if (product.getComType() != null) {
			criteria.andComTypeEqualTo(product.getComType());
		}

		List<ProductVo> list = productMapper.selectByExample(example);

		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (ProductVo vo : list) {
			if (vo.getCreateTime() != null) {
				vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
			}
		}

		PageInfo<ProductVo> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<ProductVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public Product findProductById(int productId) {
		return productMapper.selectByPrimaryKey(productId);
	}

	@Override
	public List<ProductVo> findAll() {
		ProductExample productExample = new ProductExample();
		return productMapper.selectByExample(productExample);
	}

	@Override
	public int deleteProductById(int productId) {
		return productMapper.deleteByPrimaryKey(productId);
	}

	@Override
	public int addProduct(Product product) {
		try {
			return productMapper.insert(product);
		} catch (Exception e) {
			logger.error("", e);
		}
		return 0;
	}

	@Override
	public int editProductById(Product product) {
		return productMapper.updateByPrimaryKeySelective(product);
	}


}
