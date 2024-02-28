package com.tennecotecnic.onlineshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
    public static void readData() throws Exception {
        String data ="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                data = reader.readLine();
                CmdController.userDataProcessing(data);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        reader.close();
    }
}
