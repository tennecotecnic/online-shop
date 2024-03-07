package com.tennecotecnic.onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennecotecnic.onlineshop.model.Product;
import com.tennecotecnic.onlineshop.repository.Stock;

import java.io.IOException;

public class ProductController {
    Stock stock = new Stock();

    void productDataProcessing(String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] array = data.split("\\?");
        switch (array[0]) {
            case ("product/create"):
                Product product = objectMapper.readValue(array[1], Product.class);
                stock.create(product);
                break;
            case ("product/getAll"):
                System.out.println(stock.findAll());
                break;
            case ("product/get"):
                System.out.println(stock.findByName(array[1]));
                break;
            case ("product/delete"):
                stock.delete(array[1]);
                break;
            case ("product/update"):
                Product product1 = objectMapper.readValue(array[1], Product.class);
                stock.update(product1);
                break;
            default:
                System.out.println("Invalid command for Stock.");
        }
    }
}
