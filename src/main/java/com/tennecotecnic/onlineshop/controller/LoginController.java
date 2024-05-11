package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.service.LoginService;

import java.io.IOException;

public class LoginController {

    private LoginService loginService;

    public LoginController(UserRepository userRepository, LoginService loginService) {
        this.loginService = loginService;
        // this.userRepository = userRepository;
    }

    public void processCommand(String stringFromReader)  throws IOException {
        String [] commandWithArgument = stringFromReader.split("/");
        switch (commandWithArgument[0]) {
            case("login") -> {
                loginService.login(commandWithArgument[1]);
            }
            case("logout") -> {
                loginService.logout(commandWithArgument[1]);
            }
        }
    }
}
