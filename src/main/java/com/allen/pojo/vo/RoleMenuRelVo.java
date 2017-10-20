package com.allen.pojo.vo;

import com.allen.pojo.Menu;
import com.allen.pojo.Role;
import com.allen.pojo.RoleMenuRel;
import com.allen.pojo.User;

/**
 * Created by Allen on 2017/9/15.
 */
public class RoleMenuRelVo extends RoleMenuRel {

	private Menu menu;

	private Integer parentId;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
