package com.tennecotecnic.onlineshop.model;

import com.tennecotecnic.onlineshop.util.TimeFormatUtil;

import java.time.Instant;

public abstract class Product {


    private Integer id;
    private Category category;
    private float price;
    private Instant createdAt;
    private Instant updatedAt;
    public Integer updatedBy;


    public Product(Integer id, Category category, float price) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.createdAt = TimeFormatUtil.timeFormatSetting();
        this.updatedAt = TimeFormatUtil.timeFormatSetting();
    }

    public Product() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

}
