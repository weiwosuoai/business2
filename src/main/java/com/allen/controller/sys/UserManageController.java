package com.allen.controller.sys;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.User;
import com.allen.pojo.vo.UserVo;
import com.allen.service.RoleService;
import com.allen.service.UserService;
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
 * 用户管理
 * Created by Allen on 2017/9/15.
 */

@Controller
@RequestMapping("/sys/user")
public class UserManageController {

	private static final Log logger = LogFactory.getLog(UserManageController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	/**
	 * 展示后台页面
	 * @return
	 */
	@RequestMapping("/manage/list")
	public String showUserManageList(Model model) {
		model.addAttribute("roleList", roleService.findAll());
		return "/sys/user-manage-list";
	}

	/**
	 * 获取用户管理数据
	 * @return
	 */
	@RequestMapping("/manage/list/data")
	@ResponseBody
	public BootstrapTableResult<UserVo> findUserManageListData(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
															   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
															   @RequestParam(required = false) String username,
															   @RequestParam(required = false) Integer roleId) {
		User user = new User();
		user.setUsername(username);
		user.setRoleId(roleId);
		return userService.findUserByPagination(offset, limit, user);
	}

	/**
	 * 用户添加视图
	 * @return
	 */
	@RequestMapping("/manage/add/view")
	public String showUserAddView(Model model) {
		model.addAttribute("roleList", roleService.findAll());
		return "/sys/user-manage-add";
	}

	/**
	 * 用户添加
	 * @return
	 */
	@RequestMapping("/manage/add")
	@ResponseBody
	public ServerResponse addUser(User user) {
		int count = userService.addUser(user);
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
	@RequestMapping("/manage/{userId}/edit/view")
	public String showUserEditView(@PathVariable int userId, Model model) {
		model.addAttribute("user", userService.findUserById(userId));
		model.addAttribute("roleList", roleService.findAll());
		return "/sys/user-manage-edit";
	}

	/**
	 * 角色编辑视图
	 * @return
	 */
	@RequestMapping("/manage/edit")
	@ResponseBody
	public ServerResponse editUserById(User user) {
		int count = userService.editUserById(user);
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
	@RequestMapping("/manage/{userId}/delete")
	@ResponseBody
	public ServerResponse deleteUserById(@PathVariable int userId) {
		int count = userService.deleteUserById(userId);
		if (count > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		} else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}
}
