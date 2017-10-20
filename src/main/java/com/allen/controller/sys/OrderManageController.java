package com.allen.controller.sys;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.Const;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.Order;
import com.allen.pojo.User;
import com.allen.pojo.vo.OrderVo;
import com.allen.pojo.vo.UserVo;
import com.allen.service.OrderService;
import com.allen.service.RoleService;
import com.allen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单管理
 * Created by Allen on 2017/9/15.
 */

@Controller
@RequestMapping("/sys/order/manage")
public class OrderManageController {

	private static final Log logger = LogFactory.getLog(OrderManageController.class);

	@Autowired
	private OrderService orderService;

	/**
	 * 展示后台页面
	 * @return
	 */
	@RequestMapping("/list")
	public String showUserManageList(Model model) {
		model.addAttribute("orderList", Const.OrderStatusEnum.values());
		return "/sys/order-manage-list";
	}

	/**
	 * 获取用户管理数据
	 * @return
	 */
	@RequestMapping("/list/data")
	@ResponseBody
	public BootstrapTableResult<OrderVo> findUserManageListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
																@RequestParam(value = "limit", defaultValue = "10") Integer limit,
																@RequestParam(required = false) String orderNo,
																@RequestParam(required = false) String status) {
		Order order = new Order();
		order.setOrderNo(orderNo);
		if (StringUtils.isNotBlank(status)) {
			order.setStatus(Integer.valueOf(status));
		}
		return orderService.findUserByPagination(offset, limit, order);
	}

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/{id}/detail")
	public String showOrderDetail(@PathVariable int id, Model model) {
		model.addAttribute("order", orderService.findOrderById(id));
		return "/sys/order-detail";
	}

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/orderNo/{orderNo}/detail")
	public String showOrderDetailByOrderNo(@PathVariable String orderNo, Model model) {
		model.addAttribute("order", orderService.findOrderByOrderNo(orderNo));
		return "/sys/order-detail";
	}

//	/**
//	 * 用户添加视图
//	 * @return
//	 */
//	@RequestMapping("/manage/add/view")
//	public String showUserAddView(Model model) {
//		model.addAttribute("roleList", roleService.findAll());
//		return "/sys/user-manage-add";
//	}
//
//	/**
//	 * 用户添加
//	 * @return
//	 */
//	@RequestMapping("/manage/add")
//	@ResponseBody
//	public ServerResponse addUser(User user) {
//		int count = userService.addUser(user);
//		if (count > 0) {
//			return ServerResponse.createBySuccessMessage("添加成功");
//		} else {
//			return ServerResponse.createByErrorMessage("添加失败");
//		}
//	}
//
//	/**
//	 * 用户编辑视图
//	 * @return
//	 */
//	@RequestMapping("/manage/{userId}/edit/view")
//	public String showUserEditView(@PathVariable int userId, Model model) {
//		model.addAttribute("user", userService.findUserById(userId));
//		model.addAttribute("roleList", roleService.findAll());
//		return "/sys/user-manage-edit";
//	}
//
//	/**
//	 * 角色编辑视图
//	 * @return
//	 */
//	@RequestMapping("/manage/edit")
//	@ResponseBody
//	public ServerResponse editUserById(User user) {
//		int count = userService.editUserById(user);
//		if (count > 0) {
//			return ServerResponse.createBySuccessMessage("编辑成功");
//		} else {
//			return ServerResponse.createByErrorMessage("编辑失败");
//		}
//	}
//
//	/**
//	 * 角色删除
//	 * @return
//	 */
//	@RequestMapping("/manage/{userId}/delete")
//	@ResponseBody
//	public ServerResponse deleteUserById(@PathVariable int userId) {
//		int count = userService.deleteUserById(userId);
//		if (count > 0) {
//			return ServerResponse.createBySuccessMessage("删除成功");
//		} else {
//			return ServerResponse.createByErrorMessage("删除失败");
//		}
//	}
}
