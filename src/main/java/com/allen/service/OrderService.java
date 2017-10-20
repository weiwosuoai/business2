package com.allen.service;

import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.JsTreeNode;
import com.allen.common.pojo.ServerResponse;
import com.allen.pojo.Order;
import com.allen.pojo.User;
import com.allen.pojo.vo.OrderVo;
import com.allen.pojo.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/9/15.
 */
public interface OrderService {

	ServerResponse getAlipayQrcode(Integer userId, Long orderId);

	ServerResponse alipayCallback(Map<String, String> params);

	ServerResponse findOrderStatusByOrderNo(String orderNo);

	BootstrapTableResult<OrderVo> findUserByPagination(int offset, int limit, Order order);

	OrderVo findOrderById(int id);
	OrderVo findOrderByOrderNo(String orderNo);
}
