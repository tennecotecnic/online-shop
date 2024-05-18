package com.tennecotecnic.onlineshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennecotecnic.onlineshop.controller.CmdReader;


public class OnlineShop {
    public final static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args)  throws Exception {

       // Shipping shipping1 = new Shipping("Minsk, Malinovka", "8(065) 143-79-00", 222452);
        //Purchase purchase1 = new Purchase(1, 7, 3, shipping1);
        //System.out.println(purchase1);

        CmdReader cmdReader = new CmdReader();
        cmdReader.readFromCmd();
    }


}
