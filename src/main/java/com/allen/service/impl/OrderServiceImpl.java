package com.allen.service.impl;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayMonitorService;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayMonitorServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.allen.common.pojo.BootstrapTableResult;
import com.allen.common.pojo.Const;
import com.allen.common.pojo.ServerResponse;
import com.allen.common.utils.DateTimeUtil;
import com.allen.common.utils.PropertiesUtil;
import com.allen.dao.OrderMapper;
import com.allen.dao.ProductMapper;
import com.allen.pojo.*;
import com.allen.pojo.vo.OrderVo;
import com.allen.pojo.vo.UserVo;
import com.allen.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.corba.se.idl.constExpr.Or;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单服务
 * Created by Allen on 2017/9/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

	private static final Log logger = LogFactory.getLog(OrderServiceImpl.class);

	// 支付宝当面付2.0服务
	private static AlipayTradeService tradeService;

	// 支付宝当面付2.0服务（集成了交易保障接口逻辑）
	private static AlipayTradeService   tradeWithHBService;

	// 支付宝交易保障接口服务，供测试接口api使用，请先阅读readme.txt
	private static AlipayMonitorService monitorService;

	static {
		/** 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
		 *  Configs会读取classpath下的zfbinfo.properties文件配置信息，如果找不到该文件则确认该文件是否在classpath目录
		 */
		Configs.init("zfbinfo.properties");

		/** 使用Configs提供的默认参数
		 *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
		 */
		tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

		// 支付宝当面付2.0服务（集成了交易保障接口逻辑）
		tradeWithHBService = new AlipayTradeWithHBServiceImpl.ClientBuilder().build();

		/** 如果需要在程序中覆盖Configs提供的默认参数, 可以使用ClientBuilder类的setXXX方法修改默认参数 否则使用代码中的默认设置 */
		monitorService = new AlipayMonitorServiceImpl.ClientBuilder()
				.setGatewayUrl("http://mcloudmonitor.com/gateway.do").setCharset("GBK")
				.setFormat("json").build();
	}

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductMapper productMapper;

	/**
	 * 获取支付宝二维码
	 * 
	 * @param userId
	 * @param orderId
	 * @return
	 */
	@Override
	public ServerResponse getAlipayQrcode(Integer userId, Long orderId) {
		// (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
		// 需保证商户系统端不能重复，建议通过数据库sequence生成，
		String outTradeNo =  String.valueOf(System.currentTimeMillis()
				+ (long) (Math.random() * 10000000L));

		// (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
		String subject = "xxx公司扫码支付";

		// (必填) 订单总金额，单位为元，不能超过1亿元
		// 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
		String totalAmount = "100";

		// (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
		// 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
		String undiscountableAmount = "0";

		// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
		String sellerId = "";

		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
		String body = "购买商品共100.00元";

		// 商户操作员编号，添加此参数可以为商户操作员做销售统计
		String operatorId = "test_operator_id";

		// (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
		String storeId = "test_store_id";

		// 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
//		ExtendParams extendParams = new ExtendParams();
//		extendParams.setSysServiceProviderId("2088100200300400500");

		// 支付超时，定义为120分钟
		String timeoutExpress = "120m";

//		// 商品明细列表，需填写购买商品详细信息，
//		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
//		// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
//		GoodsDetail goods1 = GoodsDetail.newInstance("goods_id001", "xxx小面包", 1000, 1);
//		// 创建好一个商品后添加至商品明细列表
//		goodsDetailList.add(goods1);
//
//		// 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
//		GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
//		goodsDetailList.add(goods2);

		// 创建扫码支付请求builder，设置请求参数
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
				.setSubject(subject).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo)
				.setUndiscountableAmount(undiscountableAmount).setSellerId(sellerId).setBody(body)
				.setOperatorId(operatorId).setStoreId(storeId)
				.setTimeoutExpress(timeoutExpress)
				.setNotifyUrl(PropertiesUtil.getProperty("alipay.callback.url")); // 支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置

		AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
		switch (result.getTradeStatus()) {
			case SUCCESS:
				logger.info("支付宝预下单成功: )");

				// TODO: 2017/9/22 订单信息入库

				Order order = new Order();
				order.setOrderNo(outTradeNo);
//				order.setUserId();
//				order.setProductId();
				order.setPrice(new BigDecimal(100));
				order.setStatus(Const.OrderStatusEnum.WAIT_PAY.getCode());
				order.setPayPlatform(Const.PayPlatformEnum.ALIPAY.getCode());
				int count = orderMapper.insert(order);
				if (count > 0) {
					AlipayTradePrecreateResponse response = result.getResponse();
					dumpResponse(response);

					String dir = "/opt/pics/qrcode/alipay";
					File file = new File(dir);
					if (!file.exists()) {
						file.setWritable(true);
						file.mkdirs();
					}

					// 需要修改为运行机器上的路径
					String qrCodePath = String.format(dir + "/qr-%s.png",
							response.getOutTradeNo());
					logger.info("filePath:" + qrCodePath);
					// 文件写入成功
					ZxingUtils.getQRCodeImge(response.getQrCode(), 256, qrCodePath);

					String qrcodeUrl = PropertiesUtil.getProperty("project.url") + "/file/download?filePath=" + qrCodePath;

					Map<String ,String> resultMap = new HashMap<>();
					resultMap.put("qrcodeUrl", qrcodeUrl);

					return ServerResponse.createBySuccess(resultMap);
				}

				return ServerResponse.createByErrorMessage("支付订单插入系统数据库失败！！！");

			case FAILED:
				logger.error("支付宝预下单失败!!!");
				return ServerResponse.createByErrorMessage("支付宝预下单失败!!!");

			case UNKNOWN:
				logger.error("系统异常，预下单状态未知!!!");
				return ServerResponse.createByErrorMessage("系统异常，预下单状态未知!!!");

			default:
				logger.error("不支持的交易状态，交易返回异常!!!");
				return ServerResponse.createByErrorMessage("不支持的交易状态，交易返回异常!!!");
		}
	}

	/**
	 * 支付宝支付回调业务处理
	 * @param params
	 * @return
	 */
	@Override
	public ServerResponse alipayCallback(Map<String, String> params) {
		// 支付宝传回的外部订单号
		String orderNo = params.get("out_trade_no");
		String platformOrderNo = params.get("trade_no");
		String orderStatus = params.get("trade_status");

		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria criteria = orderExample.createCriteria();
		criteria.andOrderNoEqualTo(orderNo);

		List<OrderVo> list = orderMapper.selectByExample(orderExample);
		if (list == null || list.size() == 0) {
			return ServerResponse.createByErrorMessage("非本系统内部订单号，回调忽略！");
		}

		Order tmp = list.get(0);
		if (tmp.getStatus() >= Const.OrderStatusEnum.PAID.getCode()) {
			return ServerResponse.createBySuccess("支付宝重复回调");
		}

		// 用户支付成功
		if (Const.AlipayCallback.TRADE_STATUS_TRADE_SUCCESS.equals(orderStatus)) {
			Order order = new Order();
			order.setPayTime(DateTimeUtil.strToDate(params.get("gmt_payment")));
			order.setStatus(Const.OrderStatusEnum.PAID.getCode());
			order.setPlatformTradeNo(platformOrderNo);

			orderExample.clear();
			OrderExample.Criteria criteria2 = orderExample.createCriteria();
			criteria2.andOrderNoEqualTo(orderNo);
			int count = orderMapper.updateByExample(order, orderExample);
			if (count > 0) {
				return ServerResponse.createBySuccess();
			}
		}
		return ServerResponse.createByErrorMessage("支付宝回调，系统更新订单状态失败!!!");
	}

	/**
	 * 根据订单号查询订单状态
	 * @param orderNo
	 * @return
	 */
	@Override
	public ServerResponse findOrderStatusByOrderNo(String orderNo) {
		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria criteria = orderExample.createCriteria();
		criteria.andOrderNoEqualTo(orderNo.trim());

		List<OrderVo> list = orderMapper.selectByExample(orderExample);
		if (list != null && list.size() > 0) {
			Map<String, Integer> map = new HashMap<>();
			map.put("orderStatus", list.get(0).getStatus());
			return ServerResponse.createBySuccess(map);
		}
		return ServerResponse.createByErrorMessage("订单号不存在！！！");
	}

	@Override
	public BootstrapTableResult<OrderVo> findUserByPagination(int offset, int limit, Order order) {
		PageHelper.startPage((offset / limit) + 1, limit);

		// 条件设置
		OrderExample example = new OrderExample();
		example.setOrderByClause("create_time desc");

		OrderExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(order.getOrderNo())) {
			criteria.andOrderNoEqualTo(order.getOrderNo().trim());
		}

		if (order.getStatus() != null) {
			criteria.andStatusEqualTo(order.getStatus());
		}

		List<OrderVo> list = orderMapper.selectByExample(example);

		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (OrderVo vo : list) {
			vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
			// 产品名称
			Product product = productMapper.selectByPrimaryKey(vo.getProductId());
			vo.setProduct(product);
		}

		PageInfo<OrderVo> pageInfo = new PageInfo<>(list);

		BootstrapTableResult<OrderVo> result = new BootstrapTableResult<>();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

	@Override
	public OrderVo findOrderById(int id) {
		OrderVo order = orderMapper.selectByPrimaryKey(id);
		// 产品名称
		Product product = productMapper.selectByPrimaryKey(order.getProductId());
		order.setProduct(product);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setCreateTimeStr(sdf.format(order.getCreateTime()));
		if (order.getPayTime() != null) {
			order.setPayTimeStr(sdf.format(order.getPayTime()));
		}
		return order;
	}

	@Override
	public OrderVo findOrderByOrderNo(String orderNo) {
		OrderExample example = new OrderExample();
		OrderExample.Criteria criteria = example.createCriteria();
		criteria.andOrderNoEqualTo(orderNo);
		List<OrderVo> list = orderMapper.selectByExample(example);

		if (list != null && list.size() > 0) {
			OrderVo order = list.get(0);
			// 产品名称
			Product product = productMapper.selectByPrimaryKey(order.getProductId());
			order.setProduct(product);
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setCreateTimeStr(sdf.format(order.getCreateTime()));
			if (order.getPayTime() != null) {
				order.setPayTimeStr(sdf.format(order.getPayTime()));
			}
			return order;
		}
		return null;
	}

	// 简单打印
	private void dumpResponse(AlipayResponse response) {
		if (response != null) {
			logger.info(String.format("code:%s, msg:%s", response.getCode(), response.getMsg()));
			if (StringUtils.isNotEmpty(response.getSubCode())) {
				logger.info(String.format("subCode:%s, subMsg:%s", response.getSubCode(),
						response.getSubMsg()));
			}
			logger.info("body:" + response.getBody());
		}
	}

}
