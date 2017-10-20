package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.pojo.Role;
import com.allen.pojo.vo.RoleVo;

import java.util.List;

/**
 * Created by Allen on 2017/9/15.
 */
public interface RoleService {

	BootstrapTableResult<RoleVo> findRoleByPagination(int offset, int limit);

	Role findRoleById(int roleId);

	List<RoleVo> findAll();

	int deleteRoleById(int roleId);

	int addRole(Role role);

	int editRoleById(Role role);

	boolean permissionset(RoleVo roleVo);

}
