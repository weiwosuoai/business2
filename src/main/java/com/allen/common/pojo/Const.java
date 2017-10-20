package com.allen.common.pojo;

/**
 * 此类用来定义一些系统中常用的常量
 * Created by Allen on 2017/9/22.
 */
public class Const {

	/**
	 * 支付平台枚举
	 */
	public enum PayPlatformEnum {
		ALIPAY(1, "支付宝"),
		WECHATPAY(2, "微信支付");

		private int code;
		private String value;
		PayPlatformEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 支付宝回调相关参数定义
	 */
	public interface AlipayCallback {
		String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
		String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

		String RESPONSE_SUCCESS = "success";
		String RESPONSE_FAILED = "failed";
	}

	/**
	 * 订单状态枚举
	 */
	public enum OrderStatusEnum {

		WAIT_PAY(0, "获取二维码，等待支付"),
		PAID(1, "已支付");

		private int code;
		private String value;
		OrderStatusEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public static OrderStatusEnum codeOf(int code) {
			for (OrderStatusEnum orderStatusEnum : values()) {
				if (orderStatusEnum.getCode() == code) {
					return orderStatusEnum;
				}
			}
			throw new RuntimeException("未找到对应的枚举类型");
		}
	}

	/**
	 * 公司类型
	 */
	public enum CompanyTypeEnum {
		NEIZI(1, "内资"),
		WAIZI(2, "外资"),
		SPECIAL(3, "特殊类企业");

		private int code;
		private String value;
		CompanyTypeEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 公司规模
	 */
	public enum CompanySizeEnum {
		SAMLL(1, "小规模"),
		NORMAL(2, "一般纳税人");

		private int code;
		private String value;
		CompanySizeEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 月份数
	 */
	public enum MonthSizeEnum {
		SIX(1, "6个月"),
		TWELVE(2, "12个月");

		private int code;
		private String value;
		MonthSizeEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 业务状态
	 */
	public enum BusinessStatusEnum {
		UNACCEPT(0, "未受理"),
		ACCEPT(1, "已受理"),
		FINISHED(2, "已完结");

		private int code;
		private String value;
		BusinessStatusEnum(int code, String value) {
			this.code = code;
			this.value = value;
		}
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
