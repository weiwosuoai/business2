package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.BusinessRequest;
import com.allen.pojo.vo.BusinessRequestVo;

public interface BusinessRequestService {

	BootstrapTableResult<BusinessRequestVo> findBusinessRequestByPagination(int offset, int limit, BusinessRequest businessRequest);

	BusinessRequest findBusinessRequestById(int productDescriptionId);

	int deleteBusinessRequestById(int productDescriptionId);

	int addBusinessRequest(BusinessRequest productDescription);

	int editBusinessRequestById(BusinessRequest productDescription);

	ServerResponse acceptBusinessRequestById(int id);
	ServerResponse finishBusinessRequestById(int id);




}
