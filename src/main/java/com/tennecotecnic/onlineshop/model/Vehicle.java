package com.tennecotecnic.onlineshop.model;

public abstract class Vehicle  extends Product {

    private Integer weight;
    private String brand;
    private String model;
    private Integer maxSpeed;
    private VehicleEnergyType energyType;
    private VehicleType vehicleType;


    public Vehicle(Integer id, Category category, float price, Integer weight,
                   String brand, String model, Integer maxSpeed, VehicleEnergyType energyType,
                   VehicleType vehicleType) {
        super(id, category, price);
        this.weight = weight;
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.energyType = energyType;
        this.vehicleType = vehicleType;
    }

    public Vehicle (){
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public VehicleEnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(VehicleEnergyType energyType) {
        this.energyType = energyType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
