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


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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
