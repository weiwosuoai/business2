package com.allen.controller.sys;

import com.allen.common.pojo.Const;
import com.allen.pojo.Product;
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
import com.allen.pojo.vo.ProductVo;
import com.allen.service.ProductService;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品管理控制类
 */
@Controller
@RequestMapping("/sys/product")
public class ProductController {

	private static final Log logger = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * 展示产品列表
	 * @return
	 */
	@RequestMapping("/list")
	public String showProductList(Model model) {
		model.addAttribute("companyTypeList", Const.CompanyTypeEnum.values());
		return "/sys/product-list";
	}
	
	

	/**
	 * 获取产品数据
	 * @return
	 */
	@RequestMapping("/list/data")
	@ResponseBody
	public BootstrapTableResult<ProductVo> findProductListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
															   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
															   @RequestParam(required = false) String productName,
															   @RequestParam(required = false) String comType) {
		Product product = new Product();
		product.setProductName(productName);
		if (!StringUtils.isEmpty(comType)) {
			product.setComType(Integer.valueOf(comType));
		}
		return productService.findProductByPagination(offset, limit, product);
	}

	/**
	 * 产品添加视图
	 * @return
	 */
	@RequestMapping("/add/view")
	public String showProductAddView(Model model) {
		model.addAttribute("companyTypeList", Const.CompanyTypeEnum.values());
		model.addAttribute("companySizeList", Const.CompanySizeEnum.values());
		model.addAttribute("monthSizeList", Const.MonthSizeEnum.values());
		return "/sys/product-add";
	}

	/**
	 * 用户添加
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse addProduct(Product product) {
		int count = productService.addProduct(product);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("添加成功");
		} else {
			return ServerResponse.createByErrorMessage("添加失败");
		}
	}

	/**
	 * 产品编辑视图
	 * @return
	 */
	@RequestMapping("/{productId}/edit/view")
	public String showProductEditView(@PathVariable int productId, Model model) {
		model.addAttribute("product", productService.findProductById(productId));
		model.addAttribute("companyTypeList", Const.CompanyTypeEnum.values());
		model.addAttribute("companySizeList", Const.CompanySizeEnum.values());
		model.addAttribute("monthSizeList", Const.MonthSizeEnum.values());
		return "/sys/product-edit";
	}

	/**
	 * 产品编辑
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public ServerResponse editProductById(Product product) {
		int count = productService.editProductById(product);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("编辑成功");
		} else {
			return ServerResponse.createByErrorMessage("编辑失败");
		}
	}

	/**
	 * 产品删除
	 * @return
	 */
	@RequestMapping("/{productId}/delete")
	@ResponseBody
	public ServerResponse deleteProductById(@PathVariable int productId) {
		int count = productService.deleteProductById(productId);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}


}
