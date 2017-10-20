package com.allen.controller.sys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.allen.pojo.ProductDescription;
import com.allen.pojo.ProductDescriptionVo;
import com.allen.pojo.ProductDescriptionWithBLOBs;
import com.allen.service.ProductService;
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
import com.allen.common.utils.FileUtil;
import com.allen.common.utils.PropertiesUtil;
import com.allen.service.ProductDescriptionService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sys/product/desc")
public class ProductDescriptionController {

	private static final Log logger = LogFactory.getLog(ProductDescriptionController.class);

	@Autowired
	private ProductDescriptionService productDescriptionService;
	@Autowired
	private ProductService productService;

	/**
	 * 展示后台页面
	 * @return
	 */
	@RequestMapping("/list")
	public String showProductDescriptionList(Model model) {
		return "/sys/product-desc-list";
	}
	
	

	/**
	 * 获取产品数据
	 * @return
	 */
	@RequestMapping("/list/data")
	@ResponseBody
	public BootstrapTableResult<ProductDescriptionWithBLOBs> findProductDescriptionListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
																							@RequestParam(value = "limit", defaultValue = "10") Integer limit,
																							@RequestParam(required = false) String descName) {
		ProductDescription productDescription = new ProductDescription();
		productDescription.setDescName(descName);
		BootstrapTableResult rs = productDescriptionService.findProductDescriptionByPagination(offset, limit, productDescription);
		return rs;
	}

	/**
	 * 用户添加视图
	 * @return
	 */
	@RequestMapping("/add/view")
	public String showProductDescriptionAddView(Model model, ProductDescription productDescription) {
		model.addAttribute("productList", productService.findAll());
		return "/sys/product-desc-add";
	}

	/**
	 * 用户添加
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse addProductDescription(@RequestParam(value = "file", required = false) MultipartFile file, ProductDescriptionVo productDescription) {
		if (file != null) {
			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.indexOf("."));

			String fileName =  System.currentTimeMillis() + suffix;
			File targetFile = new File(PropertiesUtil.getProperty("upload.file.dir"), fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}

			try {
				file.transferTo(targetFile);
			} catch (IOException e) {
				logger.error("", e);
			}

			// 文件存放路径
			productDescription.setFlowImage(PropertiesUtil.getProperty("upload.file.dir") + fileName);
		}

		int count = productDescriptionService.addProductDescription(productDescription);
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
	@RequestMapping("/{productDescriptionId}/edit/view")
	public String showProductDescriptionEditView(@PathVariable int productDescriptionId, Model model) {
		model.addAttribute("productDescription", productDescriptionService.findProductDescriptionById(productDescriptionId));
		model.addAttribute("productList", productService.findAll());
		return "/sys/product-desc-edit";
	}

	/**
	 * 角色编辑视图
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public ServerResponse editProductDescriptionById(@RequestParam(value = "file", required = false) MultipartFile file, ProductDescriptionWithBLOBs productDescription) {
		if (file != null) {
			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.indexOf("."));

			String fileName =  System.currentTimeMillis() + suffix;
			File targetFile = new File(PropertiesUtil.getProperty("upload.file.dir"), fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}

			try {
				file.transferTo(targetFile);
			} catch (IOException e) {
				logger.error("", e);
			}

			// 文件存放路径
			productDescription.setFlowImage(PropertiesUtil.getProperty("upload.file.dir") + fileName);
		}

		int count = productDescriptionService.editProductDescriptionById(productDescription);
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
	@RequestMapping("/{productDescriptionId}/delete")
	@ResponseBody
	public ServerResponse deleteProductDescriptionById(@PathVariable int productDescriptionId) {
		int count = productDescriptionService.deleteProductDescriptionById(productDescriptionId);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}


}
