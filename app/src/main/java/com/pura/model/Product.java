package com.pura.model;

import java.io.Serializable;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class Product implements Serializable{
    private String productName;
    private String productPrice;
    private String offPercent;

    public Product() {
    }

    public Product(String productName, String productPrice, String offPercent) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.offPercent = offPercent;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getOffPercent() {
        return offPercent;
    }

    public void setOffPercent(String offPercent) {
        this.offPercent = offPercent;
    }
}
