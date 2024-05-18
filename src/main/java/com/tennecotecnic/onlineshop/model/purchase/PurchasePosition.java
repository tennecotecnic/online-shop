package com.tennecotecnic.onlineshop.model.purchase;

import com.tennecotecnic.onlineshop.model.product.Product;

public class PurchasePosition {

    private Integer productId;
    private String description;
    private float quantity;
    private float productPrice;
    private float cost;

    public PurchasePosition(Product product, float quantity) {
        this.productId = product.getId();
        this.description = product.getShortInfo();
        this.quantity = quantity;
        this.productPrice = product.getPrice();
        this.cost = quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return "{\"id\":" + productId
                + ",\"description\":\"" + description
                + "\",\"quantity\":\"" + quantity
                + "\",\"productPrice\":\"" + productPrice
                + "\",\"cost\":\"" + cost + "\"}";
    }
}
