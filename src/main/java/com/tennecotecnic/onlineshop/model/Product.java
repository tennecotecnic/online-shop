package com.tennecotecnic.onlineshop.model;

public class Product {
    public String nameOfProduct;
    public float priceOfProduct;
    private float quantityInStock;
    public String units;          //единицы измерения

    public Product(String name, float price, float quantity) {
        nameOfProduct = name;
        priceOfProduct = price;
        quantityInStock = quantity;
    }


}
