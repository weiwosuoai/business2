package com.allen.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * jstree 数据
 * Created by Allen on 2017/9/17.
 */
public class JsTreeNodeState implements Serializable {

	// 是否被选中
	private boolean selected;

	public JsTreeNodeState() {
	}

	public JsTreeNodeState(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
