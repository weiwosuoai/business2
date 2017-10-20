package com.allen.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * jstree 数据
 * Created by Allen on 2017/9/17.
 */
public class JsTreeNode implements Serializable {

	/** 节点 id */
	private Integer id;
	/** 节点名称 */
	private String text;
	/** 是否有子节点 */
	private List<JsTreeNode> children;

	private JsTreeNodeState state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<JsTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<JsTreeNode> children) {
		this.children = children;
	}

	public JsTreeNodeState getState() {
		return state;
	}

	public void setState(JsTreeNodeState state) {
		this.state = state;
	}
}
