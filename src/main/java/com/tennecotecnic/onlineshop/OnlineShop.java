package com.tennecotecnic.onlineshop;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class OnlineShop {
    public static void main(String[] args) {

        UserInMemoryRepository userInMemoryRepository = new UserInMemoryRepository();
        var userList = userInMemoryRepository.findAll();
        //userInMemoryRepository.create(new User(11));


        System.out.println("Введите логин: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(java.lang.System.in));
            String login = reader.readLine();
            System.out.println(login);
            System.out.println("Введите пароль: ");


        }
        catch (IOException e) {
            java.lang.System.out.println(e.getMessage());
        }

    }
}
