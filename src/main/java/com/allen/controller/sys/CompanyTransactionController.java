package com.allen.controller.sys;

import com.allen.pojo.vo.CompanyTransactionVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.CompanyTransaction;
import com.allen.service.CompanyTransactionService;

@Controller
@RequestMapping("/sys/trans")
public class CompanyTransactionController {

	private static final Log logger = LogFactory.getLog(CompanyTransactionController.class);

	@Autowired
	private CompanyTransactionService companyTransactionService;

	/**
	 * 出售
	 * @return
	 */
	@RequestMapping("/list/sell")
	public String showCompanySellList(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/company-sell-list";
	}
	
	/**
	 * 求购
	 * @return
	 */
	@RequestMapping("/list/buy")
	public String showCompanyBuyList(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/company-buy-list";
	}

	/**
	 * 获取产品数据
	 * @return
	 */
	@RequestMapping("/list/data")
	@ResponseBody
	public BootstrapTableResult<CompanyTransactionVo> findCompanyTransactionListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
																					 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
																					 @RequestParam(required = false) String city,
																					 @RequestParam(required = false) String priceStart,
																					 @RequestParam(required = false) String priceEnd,
																					 @RequestParam(required = false) String comTranType,
																					 @RequestParam(required = false) String industry) {
		CompanyTransactionVo companyTransaction = new CompanyTransactionVo();
		companyTransaction.setStatus(Integer.valueOf(comTranType));
		companyTransaction.setPriceStart(priceStart);
		companyTransaction.setPriceEnd(priceEnd);
		companyTransaction.setCity(city);
		companyTransaction.setIndustry(industry);
		BootstrapTableResult rs = companyTransactionService.findCompanyTransactionByPagination(offset, limit, companyTransaction);
		return rs;
	}

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/{id}/detail")
	public String showComTranDetail(@PathVariable int id, Model model) {
		model.addAttribute("comTran", companyTransactionService.findCompanyTransactionById(id));
		return "/sys/comtran-detail";
	}

	/**
	 * 受理
	 * @return
	 */
	@RequestMapping("/{id}/accept")
	@ResponseBody
	public ServerResponse businessRequestAccept(@PathVariable int id) {
		return companyTransactionService.acceptBusinessRequestById(id);
	}

	/**
	 * 完结
	 * @return
	 */
	@RequestMapping("/{id}/finish")
	@ResponseBody
	public ServerResponse businessRequestFinish(@PathVariable int id) {
		return companyTransactionService.finishBusinessRequestById(id);
	}

	/**
	 * 用户添加视图
	 * @return
	 */
	@RequestMapping("/add/view")
	public String showCompanyTransactionAddView(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/company-trans-add";
	}

	/**
	 * 用户添加
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse addCompanyTransaction(CompanyTransaction companyTransaction) {
		int count = companyTransactionService.addCompanyTransaction(companyTransaction);
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
	@RequestMapping("/{companyTransactionId}/edit/view")
	public String showCompanyTransactionEditView(@PathVariable int companyTransactionId, Model model) {
		model.addAttribute("companyTransaction", companyTransactionService.findCompanyTransactionById(companyTransactionId));
//		model.addAttribute("roleList", roleService.findAll());
		return "/sys/company-trans-edit";
	}

	/**
	 * 角色编辑视图
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public ServerResponse editCompanyTransactionById(CompanyTransaction companyTransaction) {
		int count = companyTransactionService.editCompanyTransactionById(companyTransaction);
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
	@RequestMapping("/{id}/delete")
	@ResponseBody
	public ServerResponse deleteCompanyTransactionById(@PathVariable int id) {
		int count = companyTransactionService.deleteCompanyTransactionById(id);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}



}
