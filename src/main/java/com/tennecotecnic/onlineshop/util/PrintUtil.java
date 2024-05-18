package com.tennecotecnic.onlineshop.util;

import java.util.Collection;

public class PrintUtil {

    public static <T> void print(Collection<T> collection) {
        for (T element : collection) {
            System.out.println(element);
        }
    }
}