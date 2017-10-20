package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.JsTreeNode;
import com.allen.pojo.Menu;
import com.allen.pojo.User;
import com.allen.pojo.vo.UserVo;

import java.util.List;

/**
 * Created by Allen on 2017/9/15.
 */
public interface MenuService {

	List<JsTreeNode> findPermissionsetByRoleId(int parentId);

}
