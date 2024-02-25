package com.tennecotecnic.onlineshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
    public static String readData() {
        String data ="";
        try {
            while(true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                data = reader.readLine();
                reader.close();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
