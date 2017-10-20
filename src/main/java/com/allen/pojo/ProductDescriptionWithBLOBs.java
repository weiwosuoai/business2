package com.allen.pojo;

public class ProductDescriptionWithBLOBs extends ProductDescription {
    private String needPapers;

    private String productDesc;

    public String getNeedPapers() {
        return needPapers;
    }

    public void setNeedPapers(String needPapers) {
        this.needPapers = needPapers == null ? null : needPapers.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }
}