package com.allen.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String productTitle;

    private Integer comType;

    private Integer subComType;

    private Integer monthSize;

    private BigDecimal price;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public Integer getComType() {
        return comType;
    }

    public void setComType(Integer comType) {
        this.comType = comType;
    }

    public Integer getSubComType() {
        return subComType;
    }

    public void setSubComType(Integer subComType) {
        this.subComType = subComType;
    }

    public Integer getMonthSize() {
        return monthSize;
    }

    public void setMonthSize(Integer monthSize) {
        this.monthSize = monthSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}