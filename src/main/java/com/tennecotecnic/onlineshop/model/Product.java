package com.tennecotecnic.onlineshop.model;

public class Product {
    public String nameOfProduct;
    public float priceOfProduct;
    private float quantityInStock;
    public String units;          //единицы измерения

    public Product(String name, float price, float quantity, String units) {
        nameOfProduct = name;
        priceOfProduct = price;
        quantityInStock = quantity;
        this.units = units;
    }

    public Product() {
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public float getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(float priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public float getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(float quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "{\"name\":" + nameOfProduct + ",\"price\":\"" + priceOfProduct + "\",\"quantity\":\"" + quantityInStock + "\",\"units\":\"" + units + "}";
    }
}
