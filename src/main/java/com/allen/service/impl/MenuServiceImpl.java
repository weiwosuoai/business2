package com.allen.service.impl;

import com.allen.common.pojo.JsTreeNode;
import com.allen.common.pojo.JsTreeNodeState;
import com.allen.dao.MenuMapper;
import com.allen.dao.RoleMenuRelMapper;
import com.allen.pojo.*;
import com.allen.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单服务
 * Created by Allen on 2017/9/15.
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RoleMenuRelMapper roleMenuRelMapper;

	/**
	 * 根据 parentId 返回 jstree 格式数据
	 * @return
	 */
	@Override
	public List<JsTreeNode> findPermissionsetByRoleId(int roleId) {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(0);

		List<Menu> list = menuMapper.selectByExample(example);

		List<JsTreeNode> nodes = new ArrayList<>();
		for (Menu menu : list) {
			JsTreeNode node = new JsTreeNode();
			node.setId(menu.getMenuId());
			node.setText(menu.getName());


//			RoleMenuRelExample.Criteria criteria1 = roleMenuRelExample.createCriteria();
//			criteria1.andRoleIdEqualTo(roleId);
//			criteria1.andMenuIdEqualTo(menu.getMenuId());
//
//			List<RoleMenuRel> roleMenuRels = roleMenuRelMapper.selectByExample(roleMenuRelExample);
//
//			JsTreeNodeState state = new JsTreeNodeState();
//			if (roleMenuRels != null && roleMenuRels.size() > 0) {
//				state.setSelected(true);
//			} else {
//				state.setSelected(false);
//			}
//			node.setState(state);

			// 判断是否有子节点
			example.clear();
			MenuExample.Criteria criteria2 = example.createCriteria();
			criteria2.andParentIdEqualTo(menu.getMenuId());
			List<Menu> subList = menuMapper.selectByExample(example);

			List<JsTreeNode> nodes2 = new ArrayList<>();
			for (Menu menu2 : subList) {
				JsTreeNode node2 = new JsTreeNode();
				node2.setId(menu2.getMenuId());
				node2.setText(menu2.getName());

				// 回显是否被选中
				RoleMenuRelExample roleMenuRelExample = new RoleMenuRelExample();
				RoleMenuRelExample.Criteria criteria3 = roleMenuRelExample.createCriteria();
				criteria3.andRoleIdEqualTo(roleId);
				criteria3.andMenuIdEqualTo(menu2.getMenuId());

				List<RoleMenuRel> roleMenuRels2 = roleMenuRelMapper.selectByExample(roleMenuRelExample);

				JsTreeNodeState state2 = new JsTreeNodeState();
				if (roleMenuRels2 != null && roleMenuRels2.size() > 0) {
					state2.setSelected(true);
				} else {
					state2.setSelected(false);
				}
				node2.setState(state2);

				nodes2.add(node2);
			}
			node.setChildren(nodes2);

			nodes.add(node);
		}
		return nodes;
	}
}
