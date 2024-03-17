package com.tennecotecnic.onlineshop.util;

import com.tennecotecnic.onlineshop.model.Product;
import com.tennecotecnic.onlineshop.model.User;

import java.util.Collection;

public class PrintUtil {

    public static void printUsers(Collection<User> array) {
        for (User user : array) {
            System.out.println(user);
        }
    }


    public static void printProducts(Collection<Product> array) {
        for (Product product : array) {
            System.out.println(product);
        }
    }
}