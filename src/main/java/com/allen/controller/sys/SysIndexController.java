package com.allen.controller.sys;

import com.allen.common.pojo.LeftMenu;
import com.allen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台主页
 * Created by Allen on 2017/9/15.
 */

@Controller
public class SysIndexController {

	@Autowired
	private UserService userService;

	/**
	 * 展示后台页面
	 * @return
	 */
	@RequestMapping("/sys")
	public String showSysIndex(Model model) {
		// 权限控制
		List<LeftMenu> list = userService.findPermissionByUserId(1);
		model.addAttribute("leftMenus", list);
		return "/sys/index";
	}
}
