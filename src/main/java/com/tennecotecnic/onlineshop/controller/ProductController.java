package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.Product;
import com.tennecotecnic.onlineshop.repository.ProductFileRepository;
import com.tennecotecnic.onlineshop.repository.ProductInMemoryRepository;
import com.tennecotecnic.onlineshop.repository.ProductRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

import java.io.IOException;

public class ProductController {
    private final ProductRepository productRepository = new ProductInMemoryRepository();
    //private final ProductRepository productRepository = new ProductFileRepository();

   public void processCommand(String stringFromReader) throws IOException {
       
                String[] commandWithArgument = stringFromReader.split("\\?");
                switch (commandWithArgument[0]) {
                    case ("product/create"):
                        Product product = objectMapper.readValue(commandWithArgument[1], Product.class);
                        productRepository.create(product);
                        break;
                    case ("product/getAll"):
                        System.out.println(productRepository.findAll());
                        //PrintUtil.printProducts(productRepository.findAll());
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


