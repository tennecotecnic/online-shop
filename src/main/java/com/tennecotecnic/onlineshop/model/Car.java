package com.tennecotecnic.onlineshop.model;

public class Car  extends  Vehicle {

    private String bodyType;


    public Car(Integer id, Category category, float price, Integer weight, String brand,
               String model, Integer maxSpeed, VehicleEnergyType energyType, VehicleType vehicleType, String bodyType) {
        super(id, category, price, weight, brand, model, maxSpeed, energyType, vehicleType);
        this.bodyType = bodyType;
    }


    public Car(){}


    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "{\"id\":" + getId() + ",\"category\":\"" + getCategory() + "\",\"price\":" + getPrice()
                + ",\"weight\":" + getWeight() + ",\"brand\":\"" + getBrand()
                + "\",\"model\":\"" + getModel() + "\",\"maxSpeed\":" + getMaxSpeed()
                + ",\"energyType\":\"" + getEnergyType() + "\",\"bodyType\":\"" + bodyType
                + "\",\"vehicleType\":\"" + getVehicleType() + "\"}";
               // + "\",\"createdAt\":\"" + getCreatedAt() + "\",\"updatedAt\":\"" + getUpdatedAt() + "\"}";
    }

}
