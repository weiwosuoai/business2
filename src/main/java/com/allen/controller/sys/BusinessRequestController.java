package com.allen.controller.sys;

import com.allen.common.pojo.Const;
import com.allen.pojo.vo.BusinessRequestVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.BusinessRequest;
import com.allen.service.BusinessRequestService;

@Controller
@RequestMapping("/sys/business")
public class BusinessRequestController {

	private static final Log logger = LogFactory.getLog(BusinessRequestController.class);

	@Autowired
	private BusinessRequestService businessRequestService;

	/**
	 * 企业登记
	 * @return
	 */
	@RequestMapping("/list")
	public String showBusinessRequestList(Model model) {
		model.addAttribute("busStatusList", Const.BusinessStatusEnum.values());
		return "/sys/business-request-list";
	}

	/**
	 * 获取企业登记数据
	 * @return
	 */
	@RequestMapping("/list/data")
	@ResponseBody
	public BootstrapTableResult<BusinessRequestVo> findbusinessRequestListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
																			   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
																			   @RequestParam(required = false) String status,
																			   @RequestParam(required = false) int busType,
																			   @RequestParam(required = false) String customerName) {
		BusinessRequest businessRequest = new BusinessRequest();
		if (!StringUtils.isEmpty(status)) {
			businessRequest.setStatus(Integer.valueOf(status));
		}
		businessRequest.setRequestType(busType);
		businessRequest.setCustomerName(customerName);
		return businessRequestService.findBusinessRequestByPagination(offset, limit, businessRequest);
	}

	/**
	 * 受理
	 * @return
	 */
	@RequestMapping("/{businessRequestId}/accept")
	@ResponseBody
	public ServerResponse businessRequestAccept(@PathVariable int businessRequestId) {
		return businessRequestService.acceptBusinessRequestById(businessRequestId);
	}

	/**
	 * 完结
	 * @return
	 */
	@RequestMapping("/{businessRequestId}/finish")
	@ResponseBody
	public ServerResponse businessRequestFinish(@PathVariable int businessRequestId) {
		return businessRequestService.finishBusinessRequestById(businessRequestId);
	}

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/{businessRequestId}/detail")
	public String showBusinessRequestDetail(@PathVariable int businessRequestId, Model model) {
		model.addAttribute("busRequest", businessRequestService.findBusinessRequestById(businessRequestId));
		return "/sys/business-detail";
	}

	
	/**
	 * 企业变更
	 * @return
	 */
	@RequestMapping("/list/change")
	public String showBusinessChangeList(Model model) {
		model.addAttribute("busStatusList", Const.BusinessStatusEnum.values());
		return "/sys/business-change-list";
	}

	/**
	 * 企业注销
	 * @return
	 */
	@RequestMapping("/list/destroy")
	public String showBusinessSpecialList(Model model) {
		model.addAttribute("busStatusList", Const.BusinessStatusEnum.values());
		return "/sys/business-destroy-list";
	}
	
	/**
	 * 代理记账
	 * @return
	 */
	@RequestMapping("/list/bookkeep")
	public String showBusinessDestroyList(Model model) {
		model.addAttribute("busStatusList", Const.BusinessStatusEnum.values());
		return "/sys/business-bookkeep-list";
	}


	/**
	 * 用户添加视图
	 * @return
	 */
	@RequestMapping("/add/view")
	public String showBusinessRequestAddView(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/business-request-add";
	}

	/**
	 * 用户添加
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse addBusinessRequest(BusinessRequest businessRequest) {
		int count = businessRequestService.addBusinessRequest(businessRequest);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("添加成功");
		} else {
			return ServerResponse.createByErrorMessage("添加失败");
		}
	}

	/**
	 * 用户编辑视图
	 * @return
	 */
	@RequestMapping("/{businessRequestId}/edit/view")
	public String showBusinessRequestEditView(@PathVariable int businessRequestId, Model model) {
		model.addAttribute("businessRequest", businessRequestService.findBusinessRequestById(businessRequestId));
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/business-request-edit";
	}

	/**
	 * 角色编辑视图
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public ServerResponse editBusinessRequestById(BusinessRequest businessRequest) {
		int count = businessRequestService.editBusinessRequestById(businessRequest);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("编辑成功");
		} else {
			return ServerResponse.createByErrorMessage("编辑失败");
		}
	}

	/**
	 * 角色删除
	 * @return
	 */
	@RequestMapping("/{businessRequestId}/delete")
	@ResponseBody
	public ServerResponse deleteBusinessRequestById(@PathVariable int businessRequestId) {
		int count = businessRequestService.deleteBusinessRequestById(businessRequestId);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}

}
