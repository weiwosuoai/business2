package com.allen.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.allen.common.pojo.Const;
import com.allen.common.pojo.ServerResponse;
import com.allen.dao.*;
import com.allen.pojo.*;
import com.allen.pojo.vo.BusinessRequestVo;
import com.allen.pojo.vo.ProductVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.service.BusinessRequestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BusinessRequestServiceImpl implements BusinessRequestService{

	private static final Log logger = LogFactory.getLog(BusinessRequestServiceImpl.class);

	@Autowired
	private BusinessRequestMapper businessRequestMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductDescriptionMapper descMappper;

	@Override
	public BootstrapTableResult<BusinessRequestVo> findBusinessRequestByPagination(int offset, int limit, BusinessRequest businessRequest) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		BusinessRequestExample example = new BusinessRequestExample();
		example.setOrderByClause("create_time desc");

		BusinessRequestExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(businessRequest.getCustomerName())) {
			criteria.andCustomerNameLike("%" + businessRequest.getCustomerName() + "%");
		}

		if (businessRequest.getStatus() != null) {
			criteria.andStatusEqualTo(businessRequest.getStatus());
		}
		// 数据类型
		criteria.andRequestTypeEqualTo(businessRequest.getRequestType());

		List<BusinessRequestVo> list = businessRequestMapper.selectByExample(example);

		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (BusinessRequestVo vo : list) {
			vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));

			ProductExample productExample = new ProductExample();
			ProductExample.Criteria criteria1 = productExample.createCriteria();
			criteria1.andProductIdEqualTo(vo.getProductId());

			List<ProductVo> list1 = productMapper.selectByExample(productExample);
			if (list1 != null && list1.size() > 0) {
				vo.setProduct(list1.get(0));
			}
		}

		PageInfo<BusinessRequestVo> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<BusinessRequestVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public BusinessRequestVo findBusinessRequestById(int businessRequestId) {
		BusinessRequestVo request = businessRequestMapper.selectByPrimaryKey(businessRequestId);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (request.getCreateTime() != null) {
			request.setCreateTimeStr(sdf.format(request.getCreateTime()));
		}

		ProductDescriptionExample descExcample = new ProductDescriptionExample();
		ProductDescriptionExample.Criteria cr = descExcample.createCriteria();
		cr.andProductIdEqualTo(request.getProductId());
		List<ProductDescription> list2 = descMappper.selectByExample(descExcample);
		if (list2 != null && list2.size() > 0) {
			request.setDescription(list2.get(0));
		}

		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria1 = productExample.createCriteria();
		criteria1.andProductIdEqualTo(request.getProductId());

		List<ProductVo> list1 = productMapper.selectByExample(productExample);
		if (list1 != null && list1.size() > 0) {
			request.setProduct(list1.get(0));
		}

		return request;
	}

	@Override
	public int deleteBusinessRequestById(int businessRequestId) {
		return businessRequestMapper.deleteByPrimaryKey(businessRequestId);
	}

	@Override
	public int addBusinessRequest(BusinessRequest businessRequest) {
		try {
			// 密码 md5 加密
//			businessRequest.setPassword(DigestUtils.md5Hex(businessRequest.getPassword().getBytes()));
			return businessRequestMapper.insert(businessRequest);
		} catch (Exception e) {
			logger.error("", e);
		}
		return 0;
	}

	@Override
	public int editBusinessRequestById(BusinessRequest businessRequest) {
		// 密码 md5 加密
//		businessRequest.setPassword(DigestUtils.md5Hex(businessRequest.getPassword().getBytes()));
		return businessRequestMapper.updateByPrimaryKeySelective(businessRequest);
	}

	@Override
	public ServerResponse acceptBusinessRequestById(int id) {

		BusinessRequest businessRequest = businessRequestMapper.selectByPrimaryKey(id);

		if (businessRequest != null && businessRequest.getStatus() == Const.BusinessStatusEnum.UNACCEPT.getCode()) {
			BusinessRequest request = new BusinessRequest();
			request.setStatus(Const.BusinessStatusEnum.ACCEPT.getCode());
			request.setRequestId(id);
			int count =  businessRequestMapper.updateByPrimaryKeySelective(request);
			if (count > 0) {
				return ServerResponse.createBySuccessMessage("受理成功");
			} else {
				return ServerResponse.createByErrorMessage("受理失败");
			}
		} else {
			return ServerResponse.createByErrorMessage("该记录无法受理");
		}
	}

	@Override
	public ServerResponse finishBusinessRequestById(int id) {
		BusinessRequest businessRequest = businessRequestMapper.selectByPrimaryKey(id);

		if (businessRequest != null && businessRequest.getStatus() == Const.BusinessStatusEnum.ACCEPT.getCode()) {
			BusinessRequest request = new BusinessRequest();
			request.setStatus(Const.BusinessStatusEnum.FINISHED.getCode());
			request.setRequestId(id);
			int count =  businessRequestMapper.updateByPrimaryKeySelective(request);
			if (count > 0) {
				return ServerResponse.createBySuccessMessage("完结成功");
			} else {
				return ServerResponse.createByErrorMessage("完结失败");
			}
		} else {
			return ServerResponse.createByErrorMessage("该记录无法完结");
		}
	}
}
