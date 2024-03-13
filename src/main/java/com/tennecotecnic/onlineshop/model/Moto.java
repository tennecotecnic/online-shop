package com.tennecotecnic.onlineshop.model;

public class Moto extends Vehicle {


    private Integer wheelCount;
    private boolean withSidecar;


    public Moto(Integer id, Category category, float price, Integer weight, String brand,
                String model, Integer maxSpeed, VihicleEnergyType energyType, VihicleType vihicleType, Integer wheelCount,
                boolean withSidecar) {
        super(id, category, price, weight, brand, model, maxSpeed, energyType, vihicleType);
        this.wheelCount = wheelCount;
        this.withSidecar = withSidecar;
    }

    public Moto() {}

    public Integer getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(Integer wheelCount) {
        this.wheelCount = wheelCount;
    }

    public boolean isWithSidecar() {
        return withSidecar;
    }

    public void setWithSidecar(boolean withSidecar) {
        this.withSidecar = withSidecar;
    }

    @Override
    public String toString() {
        return "{\"id\":" + getId() + ",\"category\":\"" + getCategory() + "\",\"price\":" + getPrice()
                + ",\"weight\":" + getWeight() + ",\"brand\":\"" + getBrand()
                + "\",\"model\":\"" + getModel() + "\",\"maxSpeed\":" + getMaxSpeed()
                + ",\"energyType\":\"" + getEnergyType() + "\",\"wheelCount\":" + wheelCount
                + ",\"withSideCar\":" + withSidecar + ",\"createdAt\":\"" + getCreatedAt() +  "\",\"updatedAt\":\"" + getUpdatedAt() + "\"}";
    }
}
