package com.tennecotecnic.onlineshop.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdController {


     static void userDataProcessing(String data) throws  IOException, JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String [] array = data.split("\\?");
        switch (array[0])  {
            case("user/create"):
                User user = objectMapper.readValue(array[1], User.class);
                UserInMemoryRepository.create(user);
                break;
            case("user/getAll"):
                System.out.println(UserInMemoryRepository.findAll());
                break;
            case("user/get"):
                System.out.println(UserInMemoryRepository.findById(Integer.parseInt(array[1])));
                break;
            case("user/delete"):
                UserInMemoryRepository.delete(Integer.parseInt(array[1]));
                break;
            case("user/update"):
                User user1 = objectMapper.readValue(array[1], User.class);
                UserInMemoryRepository.update(user1);
                break;
            default:
                System.out.println("Invalid command!");
        }
    }
}
