package com.pura.model;

import java.io.Serializable;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class TrackOrderModel implements Serializable {
    private String orderId;
    private String orderDate;
    private String productName;
    private String productPrice;
    private String deliveryStatus;

    public TrackOrderModel(String orderId, String orderDate, String productName,
                           String productPrice, String deliveryStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.productPrice = productPrice;
        this.deliveryStatus = deliveryStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
