package com.tennecotecnic.onlineshop;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlineShop {
    public static void main(String[] args) {

        UserInMemoryRepository userInMemoryRepository = new UserInMemoryRepository();
        userInMemoryRepository.usersRepository.put(1, new User());
        userInMemoryRepository.usersRepository.put(2, new User());
        userInMemoryRepository.usersRepository.put(3, new User());
        userInMemoryRepository.usersRepository.put(4, new User());
        userInMemoryRepository.usersRepository.put(5, new User());
        userInMemoryRepository.usersRepository.put(6, new User());
        userInMemoryRepository.usersRepository.put(7, new User());
        userInMemoryRepository.usersRepository.put(8, new User());
        userInMemoryRepository.usersRepository.put(9, new User());
        userInMemoryRepository.usersRepository.put(10, new User());

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
