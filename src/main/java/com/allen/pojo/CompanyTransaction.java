package com.allen.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CompanyTransaction {
	
    private Integer transId;

    private Integer transType; //交易类型  1、出售  2、求购
	
	private String city; //所在城市
	
	private String companyName;  //公司名称

	private String licenseImage;  //营业执照存放路径
	
	private Integer debt;  //是否有债务  0、无 1、有债务 2、有债权 3、有不良记录
	
	private Integer financeStatus;  //财务情况  0、零申报 1、亏损  2、赢利
	
	private Integer permit;  // 0、无  1、有
	
	private String permitImage; //许可证存放路径
	
	private String industry; //所属行业
	
	private Integer bargain; //可否议价  0、否 1、是
	
	private Integer regDuration;  //注册时间  0、1年以内  1、一年以上 2、2年以上  3、3年以上
	
	private BigDecimal price;  //价格
	
	private String mobile; //联系电话
	
	private String validCode;  //验证码
	
	private Date validDateEnd; //有效期截至
	
	private Integer status;
	
	private Integer acceptUserId;  //经办人员ID
	
	private String acceptUserName;  //经办人员姓名
	
	private Date createTime;
	
	private Date acceptTime;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLicenseImage() {
        return licenseImage;
    }

    public void setLicenseImage(String licenseImage) {
        this.licenseImage = licenseImage == null ? null : licenseImage.trim();
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public Integer getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(Integer financeStatus) {
        this.financeStatus = financeStatus;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }

    public String getPermitImage() {
        return permitImage;
    }

    public void setPermitImage(String permitImage) {
        this.permitImage = permitImage == null ? null : permitImage.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getBargain() {
        return bargain;
    }

    public void setBargain(Integer bargain) {
        this.bargain = bargain;
    }

    public Integer getRegDuration() {
        return regDuration;
    }

    public void setRegDuration(Integer regDuration) {
        this.regDuration = regDuration;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode == null ? null : validCode.trim();
    }

    public Date getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
}