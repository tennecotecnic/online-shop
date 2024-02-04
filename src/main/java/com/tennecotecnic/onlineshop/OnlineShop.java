package com.tennecotecnic.onlineshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlineShop {
    public static void main(String[] args) {
        java.lang.System.out.println("Введите логин: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(java.lang.System.in));
            String login = reader.readLine();

        }
        catch (IOException e) {
            java.lang.System.out.println(e.getMessage());
        }

    }
}
