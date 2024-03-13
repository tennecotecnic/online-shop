package com.tennecotecnic.onlineshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennecotecnic.onlineshop.controller.CmdReader;
import com.tennecotecnic.onlineshop.controller.UserController;


public class OnlineShop {
    public final static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args)  throws Exception {

        CmdReader cmdReader = new CmdReader();
        cmdReader.readFromCmd();
    }
}
