package com.allen.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2017/9/15.
 */
@Controller
public class PortalIndexController {

	/**
	 * 展示企业门户页面
	 * @return
	 */
	@RequestMapping("/")
	public String showPortalIndex() {
		return "/portal/index";
	}

}
