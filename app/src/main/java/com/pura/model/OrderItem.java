package com.pura.model;

/**
 * Created by Manish-Pc on 23/02/2018.
 */

public class OrderItem {
    private String itemName;
    private String itemPrice;
    private String itemCount;

    public OrderItem() {
    }

    public OrderItem(String itemName, String itemPrice, String itemCount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }
}
