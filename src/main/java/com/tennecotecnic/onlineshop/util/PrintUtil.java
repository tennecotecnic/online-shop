package com.tennecotecnic.onlineshop.util;

import com.tennecotecnic.onlineshop.model.Product;
import com.tennecotecnic.onlineshop.model.User;
import java.util.Collection;

public class PrintUtil {

    public static <T> void print(Collection<T> collection) {
        for (T element : collection) {
            System.out.println(element);
        }
    }
}