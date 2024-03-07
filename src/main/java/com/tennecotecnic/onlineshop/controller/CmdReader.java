package com.tennecotecnic.onlineshop.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CmdReader {

    UserController userController = new UserController();
    ProductController productController = new ProductController();


    public void readFromCmd() throws Exception {
        String data;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter the command");
                data = reader.readLine();
                String[] array = data.split("/");
                switch (array[0]) {
                    case ("user") -> userController.processCommand(data);
                    case ("product") -> productController.processCommand(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        reader.close();
    }

}
