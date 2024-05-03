package com.easypoi.test;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class OrderDetail {
    @Excel(name = "商品ID", width = 20)
    private String productId;

    @Excel(name = "商品名称", width = 30)
    private String productName;

    @Excel(name = "数量", width = 20)
    private Integer quantity;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }
}