package com.allen.pojo;

public class ProductDescription {
    private Integer descId;

    private Integer productId;

    private String descName;

    private String flowImage;

    private String remark;

    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName == null ? null : descName.trim();
    }

    public String getFlowImage() {
        return flowImage;
    }

    public void setFlowImage(String flowImage) {
        this.flowImage = flowImage == null ? null : flowImage.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}