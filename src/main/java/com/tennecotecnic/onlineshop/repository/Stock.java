package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Stock {

    public static HashMap<String, Product> stockOfProducts = new HashMap<>();

    public Stock() {
        stockOfProducts.put("Яблоко", new Product("Яблоко", 3.26f, 15.0f, "кг"));
        stockOfProducts.put("Банан", new Product("Банан", 9.80f, 32.5f, "кг"));
        stockOfProducts.put("Батон", new Product("Батон", 1.25f, 10.0f, "шт"));

    }

    public void create(Product product) {
        String name = product.getNameOfProduct();
        stockOfProducts.put(name, product);
    }

    public Collection<Product> findAll() {
        return stockOfProducts.values();
    }

    public Product findByName(String name) {
        return stockOfProducts.get(name);
    }

    public void update(Product product) {
        stockOfProducts.put(product.getNameOfProduct(), product);
    }

    public void delete(String name) {
        stockOfProducts.remove(name);
    }


    public void print(HashMap<String, Product> map) {
        for (Map.Entry entry : map.entrySet()) {

            System.out.println(entry);

        }
    }
}
