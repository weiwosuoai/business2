package com.allen.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 权限控制，左侧菜单
 * Created by Allen on 2017/9/18.
 */
public class LeftMenu implements Serializable {

	/** 图标 */
	private String icon;
	/** 菜单名称 */
	private String name;
	/** 菜单url */
	private String url;
	/** 子菜单 */
	private List<LeftMenu> children;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<LeftMenu> getChildren() {
		return children;
	}

	public void setChildren(List<LeftMenu> children) {
		this.children = children;
	}
}
