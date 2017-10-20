package com.allen.pojo;

import java.util.Date;

public class BusinessRequest {
	
    private Integer requestId;

    private Integer descId;  //服务ID
    
    private Integer productId;  //产品ID

	private String orderNo; //订单号
	
	private Integer requestType;  //申请类型 1、企业登记 2、企业变更  3、企业注销 4、代理记账
	
	private Integer status; //当前状态   0、已申请  1、已受理  2、已完结

	private Integer acceptUserId;  //经办人员ID

	private String acceptUserName;  //经办人员姓名
	
	private String customerName;     //客户姓名
	
	private String email;     //电子邮箱
	
	private String mobile;    //联系电话
	
	private String fax;    //传真
	
	private Integer needInvoice;  //是否需要发票
	
	private String invoiceTitle;  //发票抬头
    
	private Date createTime;
	
	private Date acceptTime;

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(Integer acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public String getAcceptUserName() {
        return acceptUserName;
    }

    public void setAcceptUserName(String acceptUserName) {
        this.acceptUserName = acceptUserName == null ? null : acceptUserName.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Integer getNeedInvoice() {
        return needInvoice;
    }

    public void setNeedInvoice(Integer needInvoice) {
        this.needInvoice = needInvoice;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

	public Integer getDescId() {
		return descId;
	}

	public void setDescId(Integer descId) {
		this.descId = descId;
	}
    
    
}