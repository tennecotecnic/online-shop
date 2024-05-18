package com.tennecotecnic.onlineshop.model.purchase;

import com.tennecotecnic.onlineshop.model.product.Product;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

public class Purchase {

    public Collection<PurchasePosition> positions = new ArrayList<>();
    private Integer id;
    private Integer userId;
    private Shipping shipping;
    private final Instant createdAt;
    private Instant updatedAt;
    private Status status = Status.UNPAID;

    public Purchase() {
        createdAt = TimeFormatUtil.timeFormatSetting();
        updatedAt = TimeFormatUtil.timeFormatSetting();
    }

    public Purchase(Integer userId) {
        this.userId = userId;
        createdAt = TimeFormatUtil.timeFormatSetting();
        updatedAt = TimeFormatUtil.timeFormatSetting();
    }

    @Override
    public String toString() {
        return "{\"id\":" + id
                + ",\"userId\":" + userId
                + ",\"positions\":\"" + positions
                + ",\"createdAt\":\"" + createdAt
                + "\",\"updatedAt\":\"" + updatedAt
                + "\",\"shipping\":\"" + shipping
                + "\",\"status\":\"" + status + "\"}";
    }


    public enum Status {
        UNPAID,
        PAID,
        DELIEVERIED
    }


    public Collection<PurchasePosition> getPositions() {
        return positions;
    }
    public void setPositions(Collection<PurchasePosition> positions) {
        this.positions = positions;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
