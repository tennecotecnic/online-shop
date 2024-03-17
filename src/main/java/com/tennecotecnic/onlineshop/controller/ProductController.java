package com.tennecotecnic.onlineshop.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.tennecotecnic.onlineshop.model.*;
import com.tennecotecnic.onlineshop.repository.ProductFileRepository;
import com.tennecotecnic.onlineshop.repository.ProductInMemoryRepository;
import com.tennecotecnic.onlineshop.repository.ProductRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;
import static com.tennecotecnic.onlineshop.model.Category.FOOD;

import java.io.IOException;

public class ProductController {
    //private final ProductRepository productRepository = new ProductInMemoryRepository();
    private final ProductRepository productRepository = new ProductFileRepository();

    public void processCommand(String stringFromReader) throws IOException {
        String[] commandWithArgument = stringFromReader.split("\\?");
        switch (commandWithArgument[0]) {
            case ("product/create"):
                JsonNode rootNode = objectMapper.readTree(commandWithArgument[1]);
                JsonNode categoryNode = rootNode.path("category");
                switch (categoryNode.asText()) {
                    case ("FOOD") -> {
                        Product food = objectMapper.readValue(commandWithArgument[1], Food.class);
                        productRepository.create(food);
                    }
                    case ("BOOK") -> {
                        Product book = objectMapper.readValue(commandWithArgument[1], Book.class);
                        productRepository.create(book);
                    }
                    case ("VEHICLE") -> {
                        JsonNode categoryVihicleNode = rootNode.path("vehicleType");
                        switch (categoryVihicleNode.asText()) {
                            case ("CAR"):
                                Product car = objectMapper.readValue(commandWithArgument[1], Car.class);
                                productRepository.create(car);
                                break;
                            case ("MOTO"):
                                Product moto = objectMapper.readValue(commandWithArgument[1], Moto.class);
                                productRepository.create(moto);
                                break;
                        }
                    }
                    default -> {
                        System.out.println("incorrect category");
                    }
                }
                break;
            case ("product/getAll"):
                //System.out.println(productRepository.findAll());
                PrintUtil.printProducts(productRepository.findAll());
                break;
            case ("product/get"):
                System.out.println(productRepository.findById(Integer.parseInt(commandWithArgument[1])));
                break;
            case ("product/delete"):
                productRepository.delete(Integer.parseInt(commandWithArgument[1]));
                break;
            default:
                System.out.println("Invalid command for Product.");
        }
    }
}


