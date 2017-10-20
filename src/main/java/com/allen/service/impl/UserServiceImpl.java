package com.allen.service.impl;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.LeftMenu;
import com.allen.dao.MenuMapper;
import com.allen.dao.RoleMapper;
import com.allen.dao.RoleMenuRelMapper;
import com.allen.dao.UserMapper;
import com.allen.pojo.*;
import com.allen.pojo.vo.RoleMenuRelVo;
import com.allen.pojo.vo.RoleVo;
import com.allen.pojo.vo.UserVo;
import com.allen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/9/15.
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuRelMapper roleMenuRelMapper;
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public BootstrapTableResult<UserVo> findUserByPagination(int offset, int limit, User user) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		UserExample example = new UserExample();
		example.setOrderByClause("create_time desc");

		UserExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(user.getUsername())) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}

		if (user.getRoleId() != null) {
			criteria.andRoleIdEqualTo(user.getRoleId());
		}

		List<UserVo> list = userMapper.selectByExample(example);

		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (UserVo vo : list) {
			vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));

			// 角色关联的角色名称，角色信息启用了 mybatis 的缓存，无需通过关联查询，从数据库取，提升性能
			Role role = roleMapper.selectByPrimaryKey(vo.getRoleId());
			if (role != null) {
				vo.setRole(role);
			} else {
				vo.setRole(new Role());
			}
		}

		PageInfo<UserVo> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<UserVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public User findUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int deleteUserById(int userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int addUser(User user) {
		try {
			// 密码 md5 加密
			user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));
			return userMapper.insert(user);
		} catch (Exception e) {
			logger.error("", e);
		}
		return 0;
	}

	@Override
	public int editUserById(User user) {
		// 密码 md5 加密
		user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 根据 userId 查找用户的权限
	 * @param userId
	 * @return
	 */
	@Override
	public List<LeftMenu> findPermissionByUserId(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		// 获取到用户的角色id,查找相应的角色
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria criteria = roleExample.createCriteria();
		criteria.andRoleIdEqualTo(user.getRoleId());

		List<RoleVo> roles = roleMapper.selectByExample(roleExample);

		List<LeftMenu> leftMenuList = new ArrayList<>();

		if (roles != null && roles.size() > 0) {
			// 获取到用户的角色
			RoleVo role = roles.get(0);

			// 获取这个用户顶级菜单关系
			RoleMenuRelVo roleMenuRelVo = new RoleMenuRelVo();
			roleMenuRelVo.setRoleId(role.getRoleId());
			roleMenuRelVo.setParentId(0);

			List<RoleMenuRelVo> roleMenuRels = roleMenuRelMapper.selectMenuInfo(roleMenuRelVo);

			if (roleMenuRels != null && roleMenuRels.size() > 0) {

				// 顶级菜单信息
				for (RoleMenuRelVo roleMenuRel : roleMenuRels) {
					int menuId = roleMenuRel.getMenuId();

					LeftMenu leftMenu = new LeftMenu();
					leftMenu.setIcon(roleMenuRel.getMenu().getIcon());
					leftMenu.setName(roleMenuRel.getMenu().getName());
					leftMenu.setUrl(roleMenuRel.getMenu().getUrl());

					// children
					roleMenuRelVo.setParentId(menuId);
					List<RoleMenuRelVo> subRoleMenuRels = roleMenuRelMapper.selectMenuInfo(roleMenuRelVo);
					List<LeftMenu> subLeftMenus = new ArrayList<>();
					for (RoleMenuRelVo sub : subRoleMenuRels) {
						LeftMenu leftMenu2 = new LeftMenu();
						leftMenu2.setIcon(sub.getMenu().getIcon());
						leftMenu2.setName(sub.getMenu().getName());
						leftMenu2.setUrl(sub.getMenu().getUrl());
						subLeftMenus.add(leftMenu2);
					}
					leftMenu.setChildren(subLeftMenus);
					leftMenuList.add(leftMenu);
				}
			}
		}
		return leftMenuList;
	}
}
