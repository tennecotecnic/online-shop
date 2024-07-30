package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.product.Food;
import com.tennecotecnic.onlineshop.model.product.Product;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.service.LoginService;
import com.tennecotecnic.onlineshop.service.PurchaseService;
import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

import java.io.IOException;

public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public void processCommand(String stringFromReader)  throws IOException {
        String [] commandWithArgument = stringFromReader.split("/");
        switch (commandWithArgument[0]) {
//            case("add") -> {
//                Product product = objectMapper.readValue(commandWithArgument[2], Product.class);
//                purchaseService.addPurchasePosition(Integer.parseInt(commandWithArgument[1]),
//                        product, Float.parseFloat(commandWithArgument[3]));
//            }
            case("updatePurchase") -> {
                Product product = objectMapper.readValue(commandWithArgument[2], Product.class);
                purchaseService.updatePurchasePosition(Integer.parseInt(commandWithArgument[1]),
                        product, Float.parseFloat(commandWithArgument[3]));
            }
            case("updateStatus") -> {

            }
        }
    }
}
