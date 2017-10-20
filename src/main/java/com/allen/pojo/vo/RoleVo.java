package com.allen.pojo.vo;

import com.allen.pojo.Role;

/**
 * Created by Allen on 2017/9/15.
 */
public class RoleVo extends Role {

	// 页面显示日期字符串
	private String createTimeStr;

	// 菜单ids
	private String menuIds;

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
