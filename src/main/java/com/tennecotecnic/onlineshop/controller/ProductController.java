package com.tennecotecnic.onlineshop.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.tennecotecnic.onlineshop.model.*;
import com.tennecotecnic.onlineshop.repository.ProductFileRepository;
import com.tennecotecnic.onlineshop.repository.ProductInMemoryRepository;
import com.tennecotecnic.onlineshop.repository.ProductRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

import java.io.IOException;

public class ProductController {
//    private final ProductRepository productRepository = new ProductInMemoryRepository();
 private final ProductRepository productRepository = new ProductFileRepository();
    public void processCommand(String stringFromReader) throws IOException {
        String[] commandWithArgument = stringFromReader.split("\\?");
        switch (commandWithArgument[0]) {
            case ("product/create") -> {
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
                            case ("CAR") -> {
                                Product car = objectMapper.readValue(commandWithArgument[1], Car.class);
                                productRepository.create(car);
                            }
                            case ("MOTO") -> {
                                Product moto = objectMapper.readValue(commandWithArgument[1], Moto.class);
                                productRepository.create(moto);
                            }
                            default -> System.out.println("incorrect vehicle type");
                        }
                    }
                    default -> {
                        System.out.println("incorrect category");
                    }
                }
            }
            case ("product/getAll") -> {
                if (commandWithArgument.length == 1) {
                    PrintUtil.printProducts(productRepository.findAll());
                } else {
                    String[] categoryFind = commandWithArgument[1].split("=");
                    if (categoryFind[0].equals("category")) {
                        PrintUtil.printProducts(productRepository.findByCategory(categoryFind[1]));
                    } else {
                        System.out.println("incorrect command for searching");
                    }
                }
            }
            case ("product/get") ->
                    System.out.println(productRepository.findById(Integer.parseInt(commandWithArgument[1])));
            case ("product/delete") -> productRepository.delete(Integer.parseInt(commandWithArgument[1]));
            default -> System.out.println("Invalid command for Product.");
        }
    }
}


