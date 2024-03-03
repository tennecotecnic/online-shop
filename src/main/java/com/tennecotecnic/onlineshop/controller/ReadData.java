package com.tennecotecnic.onlineshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadData {

    CmdController cmdController = new CmdController();
    ProductController productController = new ProductController();

    public void readData() throws Exception {
        String data;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter the command");
                data = reader.readLine();
                String[] array = data.split("/");
                if (array[0].equals("user")) {
                    cmdController.userDataProcessing(data);
                } else if (array[0].equals("product")) {
                    productController.productDataProcessing(data);
                } else System.out.println("Invalid command");

            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        reader.close();
    }
}
