package com.allen.service.impl;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.dao.MenuMapper;
import com.allen.dao.RoleMapper;
import com.allen.dao.RoleMenuRelMapper;
import com.allen.pojo.*;
import com.allen.pojo.vo.RoleVo;
import com.allen.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Allen on 2017/9/15.
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuRelMapper roleMenuRelMapper;
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public BootstrapTableResult<RoleVo> findRoleByPagination(int offset, int limit) {
		PageHelper.startPage((offset/limit) + 1, limit);

		RoleExample example = new RoleExample();
		example.setOrderByClause("create_time desc");
		List<RoleVo> list = roleMapper.selectByExample(example);

		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (RoleVo role : list) {
			role.setCreateTimeStr(sdf.format(role.getCreateTime()));
		}

		PageInfo<RoleVo> pageInfo = new PageInfo<RoleVo>(list);

		BootstrapTableResult<RoleVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public Role findRoleById(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public List<RoleVo> findAll() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public int deleteRoleById(int roleId) {
		// 同时要删除这个角色对应的权限映射关系
		RoleMenuRelExample example = new RoleMenuRelExample();
		RoleMenuRelExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		roleMenuRelMapper.deleteByExample(example);

		return roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public int addRole(Role role) {
		return roleMapper.insert(role);
	}

	@Override
	public int editRoleById(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	@Transactional
	public boolean permissionset(RoleVo roleVo) {
		String menuIds = roleVo.getMenuIds();

		// 先删除这个角色已存在的权限映射记录
		RoleMenuRelExample roleMenuRelExample = new RoleMenuRelExample();
		RoleMenuRelExample.Criteria criteria = roleMenuRelExample.createCriteria();
		criteria.andRoleIdEqualTo(roleVo.getRoleId());

		roleMenuRelMapper.deleteByExample(roleMenuRelExample);

		// 插入新的角色权限映射关系
		String[] menuIdArr = menuIds.split(",");

		boolean isSuccess = true;
		for (int i = 0; i < menuIdArr.length; i++) {
			String menuId = menuIdArr[i];

			// 由于前段 jstree 控件的 bug, 可能导致父级菜单 id 没上传的情况，需要判断
			// 只对二级菜单判断，判断其父级菜单映射关系是否入库，否则入库
			// 拿到父级菜单id
			Menu menu = menuMapper.selectByPrimaryKey(Integer.valueOf(menuId));

			if (menu.getParentId() != 0) { // 非顶级菜单
				roleMenuRelExample.clear();
				RoleMenuRelExample.Criteria criteria2 = roleMenuRelExample.createCriteria();
				criteria2.andRoleIdEqualTo(roleVo.getRoleId());
				criteria2.andMenuIdEqualTo(menu.getParentId());

				List<RoleMenuRel> list = roleMenuRelMapper.selectByExample(roleMenuRelExample);
				if (list == null || list.size() == 0) { // 子集菜单的父菜单id不存在库中
					RoleMenuRel rel = new RoleMenuRel();
					rel.setRoleId(roleVo.getRoleId());
					rel.setMenuId(menu.getParentId());


					int count = roleMenuRelMapper.insert(rel);
					if (count == 0) {
						isSuccess = false;
					}
				}
			}

			// 查看要入库的角色菜单关系记录，库中是否已经存在
			roleMenuRelExample.clear();
			RoleMenuRelExample.Criteria criteria3 = roleMenuRelExample.createCriteria();
			criteria3.andRoleIdEqualTo(roleVo.getRoleId());
			criteria3.andMenuIdEqualTo(Integer.valueOf(menuId));

			List<RoleMenuRel> roleMenuRels = roleMenuRelMapper.selectByExample(roleMenuRelExample);

			if (roleMenuRels == null || roleMenuRels.size() == 0) {
				RoleMenuRel rel = new RoleMenuRel();
				rel.setRoleId(roleVo.getRoleId());
				rel.setMenuId(Integer.valueOf(menuId));

				int count = roleMenuRelMapper.insert(rel);
				if (count == 0) {
					isSuccess = false;
				}
			}


		}
		return isSuccess;
	}
}
