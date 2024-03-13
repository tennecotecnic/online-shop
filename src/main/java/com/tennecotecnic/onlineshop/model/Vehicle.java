package com.tennecotecnic.onlineshop.model;

public abstract class Vehicle  extends Product {

    private Integer weight;
    private String brand;
    private String model;
    private Integer maxSpeed;
    private VihicleEnergyType energyType;
    private VihicleType vihicleType;


    public Vehicle(Integer id, Category category, float price, Integer weight,
                   String brand, String model, Integer maxSpeed, VihicleEnergyType energyType,
                   VihicleType vihicleType) {
        super(id, category, price);
        this.weight = weight;
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.energyType = energyType;
        this.vihicleType = vihicleType;
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

    public VihicleEnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(VihicleEnergyType energyType) {
        this.energyType = energyType;
    }

    public VihicleType getVihicleType() {
        return vihicleType;
    }

    public void setVihicleType(VihicleType vihicleType) {
        this.vihicleType = vihicleType;
    }
}
