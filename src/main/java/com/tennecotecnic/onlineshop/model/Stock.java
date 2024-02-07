package com.tennecotecnic.onlineshop.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {
    {
        ArrayList<Product> stockOfProducts = new ArrayList<>();
    }
    public static void addProduct(String name, float price, float quantity) {
        Product product = new Product(name, price, quantity);

    }

}
