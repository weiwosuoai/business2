package com.allen.controller.portal;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.allen.common.pojo.Const;
import com.allen.common.pojo.ServerResponse;
import com.allen.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 订单 controller(包含支付宝和微信)
 * Created by Allen on 2017/9/20.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	private static final Log logger = LogFactory.getLog(OrderController.class);

	@Autowired
	private OrderService orderService;

	/**
	 * 获取订单的支付状态
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/status")
	@ResponseBody
	public ServerResponse getOrderStatus(String orderNo) {
		// 根据订单号查看订单表状态
		return orderService.findOrderStatusByOrderNo(orderNo);
	}


	/**
	 * 获取支付宝二维码
	 * @param userId 用户 id
	 * @param orderNo 订单号
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/alipay/qrcode" , method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse getAlipayQrcode(Integer userId, Long orderNo, HttpServletRequest request) {
		return orderService.getAlipayQrcode(userId, orderNo);
	}

	/**
	 * 支付宝支付回调
	 * @param request
	 * @return
	 */
	@RequestMapping("/alipay/callback")
	@ResponseBody
	public Object alipayCallback(HttpServletRequest request) {
		Map requestParams = request.getParameterMap();

		Map<String, String> params = new HashMap<>();

		// 迭代支付宝回调传回的参数
		for (Iterator iterator = requestParams.keySet().iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			String[] values = (String[]) requestParams.get(name);

			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		logger.info("支付宝回调，sign{} - " + params.get("sign"));
		logger.info("支付宝回调，trade_status:{} - " + params.get("trade_status"));
		logger.info("支付宝回调，参数：{} - " + params.toString());

		// 重要，重要，非常重要！！！
		// 支付宝通知验证， 防止异常通知及支付宝多次通知的情况发生 （详情参见支付宝官方文档：https://docs.open.alipay.com/194/103296/）
		params.remove("sign_type");
		try {
			boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(), "utf-8", Configs.getSignType());
			if (!alipayRSACheckedV2) {
				return ServerResponse.createByErrorMessage("非法请求，后台将会记录你的IP，若是执迷不悟，系统将自动上报网警！！！");
			}
		} catch (AlipayApiException e) {
			logger.error("", e);
		}
		
		// 验证通过，进行 业务处理
		ServerResponse serverResponse = orderService.alipayCallback(params);
		if (serverResponse.isSuccess()) {
			return Const.AlipayCallback.RESPONSE_SUCCESS;
		}
		return Const.AlipayCallback.RESPONSE_FAILED;
	}


	/**
	 * 获取微信支付二维码
	 * @param userId 用户 id
	 * @param orderNo 订单号
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wechatpay/qrcode" , method = RequestMethod.GET)
	public ServerResponse getWechatpayQrcode(Integer userId, Long orderNo, HttpServletRequest request) {
		return null;
	}

	/**
	 * 微信支付回调
	 * @param request
	 * @return
	 */
	@RequestMapping("/wechatpay/callback")
	public Object wechatpayCallback(HttpServletRequest request) {
		// TODO: 2017/9/20 修改订单号的状态为支付成功
		return null;
	}

}
