package com.allen.pojo.vo;

import com.allen.pojo.Role;
import com.allen.pojo.User;

/**
 * Created by Allen on 2017/9/15.
 */
public class UserVo extends User {

	// 页面显示日期字符串
	private String createTimeStr;

	private Role role;

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
