package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserFileRepository;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.service.LoginService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;


public class CmdReader {

    private final UserRepository userRepository = new UserFileRepository();
    //private final UserRepository userRepository = new UserInMemoryRepository();
    private LoginService loginService = new LoginService(userRepository);
    private LoginController loginController = new LoginController(userRepository, loginService);
    private UserController userController = new UserController(userRepository, loginService);
    private ProductController productController = new ProductController(loginService);




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
                    case ("login") -> loginController.processCommand(data);
                    case ("logout") -> loginController.processCommand(data);

                    default -> System.out.println("invalid command");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        reader.close();
    }

}
