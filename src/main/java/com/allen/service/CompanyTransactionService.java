package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.CompanyTransaction;
import com.allen.pojo.vo.CompanyTransactionVo;

public interface CompanyTransactionService {

	BootstrapTableResult<CompanyTransactionVo> findCompanyTransactionByPagination(int offset, int limit, CompanyTransactionVo productDescription);

	CompanyTransactionVo findCompanyTransactionById(int productDescriptionId);

	int deleteCompanyTransactionById(int productDescriptionId);

	int addCompanyTransaction(CompanyTransaction productDescription);

	int editCompanyTransactionById(CompanyTransaction productDescription);

	ServerResponse acceptBusinessRequestById(int id);
	ServerResponse finishBusinessRequestById(int id);

}
