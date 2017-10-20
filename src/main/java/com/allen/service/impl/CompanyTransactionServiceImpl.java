package com.allen.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.allen.common.pojo.Const;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.vo.CompanyTransactionVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.dao.CompanyTransactionMapper;
import com.allen.dao.MenuMapper;
import com.allen.dao.RoleMapper;
import com.allen.dao.RoleMenuRelMapper;
import com.allen.pojo.CompanyTransaction;
import com.allen.pojo.CompanyTransactionExample;
import com.allen.service.CompanyTransactionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CompanyTransactionServiceImpl implements CompanyTransactionService{

	private static final Log logger = LogFactory.getLog(CompanyTransactionServiceImpl.class);

	@Autowired
	private CompanyTransactionMapper companyTransactionMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuRelMapper roleMenuRelMapper;
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public BootstrapTableResult<CompanyTransactionVo> findCompanyTransactionByPagination(int offset, int limit, CompanyTransactionVo companyTransaction) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		CompanyTransactionExample example = new CompanyTransactionExample();
		example.setOrderByClause("create_time desc");

		CompanyTransactionExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(companyTransaction.getCity())) {
			criteria.andCityLike("%" + companyTransaction.getCity() + "%");
		}

		if (StringUtils.isNotBlank(companyTransaction.getIndustry())) {
			criteria.andIndustryLike("%" + companyTransaction.getIndustry() + "%");
		}

		// 价格区间
		if (StringUtils.isNotBlank(companyTransaction.getPriceStart()) && StringUtils.isNotBlank(companyTransaction.getPriceEnd())) {
			criteria.andPriceBetween(Double.valueOf(companyTransaction.getPriceStart()), Double.valueOf(companyTransaction.getPriceEnd()));
		}

		criteria.andStatusEqualTo(companyTransaction.getStatus());

		List<CompanyTransactionVo> list = companyTransactionMapper.selectByExample(example);

		// 格式化日期
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for (CompanyTransactionVo vo : list) {
//			vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
//
//			// 角色关联的角色名称，角色信息启用了 mybatis 的缓存，无需通过关联查询，从数据库取，提升性能
//			Role role = roleMapper.selectByPrimaryKey(vo.getRoleId());
//			if (role != null) {
//				vo.setRole(role);
//			} else {
//				vo.setRole(new Role());
//			}
//		}

		PageInfo<CompanyTransactionVo> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<CompanyTransactionVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public CompanyTransactionVo findCompanyTransactionById(int companyTransactionId) {
		CompanyTransactionVo companyTransaction = companyTransactionMapper.selectByPrimaryKey(companyTransactionId);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (companyTransaction.getCreateTime() != null) {
			companyTransaction.setCreateTimeStr(sdf.format(companyTransaction.getCreateTime()));
		}
		return companyTransaction;
	}

	@Override
	public int deleteCompanyTransactionById(int companyTransactionId) {
		return companyTransactionMapper.deleteByPrimaryKey(companyTransactionId);
	}

	@Override
	public int addCompanyTransaction(CompanyTransaction companyTransaction) {
		try {
			return companyTransactionMapper.insert(companyTransaction);
		} catch (Exception e) {
			logger.error("", e);
		}
		return 0;
	}

	@Override
	public int editCompanyTransactionById(CompanyTransaction companyTransaction) {
		return companyTransactionMapper.updateByPrimaryKeySelective(companyTransaction);
	}

	@Override
	public ServerResponse acceptBusinessRequestById(int id) {
		CompanyTransaction companyTransaction = companyTransactionMapper.selectByPrimaryKey(id);

		if (companyTransaction != null && companyTransaction.getStatus() == Const.BusinessStatusEnum.UNACCEPT.getCode()) {
			CompanyTransaction companyTransaction1 = new CompanyTransaction();
			companyTransaction1.setStatus(Const.BusinessStatusEnum.ACCEPT.getCode());
			companyTransaction1.setTransId(id);
			int count =  companyTransactionMapper.updateByPrimaryKeySelective(companyTransaction1);
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
		CompanyTransaction companyTransaction = companyTransactionMapper.selectByPrimaryKey(id);

		if (companyTransaction != null && companyTransaction.getStatus() == Const.BusinessStatusEnum.ACCEPT.getCode()) {
			CompanyTransaction companyTransaction1 = new CompanyTransaction();
			companyTransaction1.setStatus(Const.BusinessStatusEnum.FINISHED.getCode());
			companyTransaction1.setTransId(id);
			int count =  companyTransactionMapper.updateByPrimaryKeySelective(companyTransaction1);
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
