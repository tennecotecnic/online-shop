package com.tennecotecnic.onlineshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennecotecnic.onlineshop.controller.ReadData;


public class OnlineShop {
    public final static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args)  throws Exception {

        ReadData readData = new ReadData();
        readData.readData();


    }
}
