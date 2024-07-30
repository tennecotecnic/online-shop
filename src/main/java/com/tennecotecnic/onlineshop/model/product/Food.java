package com.tennecotecnic.onlineshop.model.product;

import com.tennecotecnic.onlineshop.util.MyStringUtil;


public class Food extends Product {


    private String name;
    private String brand;



    public Food(Integer id, Category category, float price, String name, String brand) {
        super(id, category, price);
        this.name = name;
        this.brand = brand;

    }

    public Food(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "{\"id\":" + getId() + ",\"category\":\"" + getCategory() + "\",\"price\":" + getPrice()
                + ",\"name\":\"" + name + "\",\"brand\":\"" + brand + "\"}";
    }

    public String getShortInfo(){
        return MyStringUtil.cutstring(brand, 9) + MyStringUtil.cutstring(name, 9);
    }
}
