package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.Buyer;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;
import java.io.IOException;
import com.tennecotecnic.onlineshop.service.LoginService;
import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class UserController {
    private UserRepository userRepository;
    private LoginService loginService;

    public UserController(UserRepository userRepository, LoginService loginService){
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    public void processCommand(String stringFromReader) throws IOException {
        String[] commandAndArgument = stringFromReader.split("\\?");

        switch (commandAndArgument[0]) {
            case ("user/create") -> {
                if (loginService.checkLogin(commandAndArgument[2])
                        && loginService.checkAdminRole(commandAndArgument[2])) {
                    Buyer buyer = objectMapper.readValue(commandAndArgument[1], Buyer.class);
                    userRepository.create(buyer);
                }
            }
            case ("user/getAll") -> {
                    if (loginService.checkLogin(commandAndArgument[1])
                            && loginService.checkAdminRole(commandAndArgument[1])) {
                    PrintUtil.print(userRepository.findAll());
                    }
            }
            case ("user/get") -> {
                if (loginService.checkLogin(commandAndArgument[2])
                        && loginService.checkAdminRole(commandAndArgument[2])) {
                    System.out.println(userRepository.findById(Integer.parseInt(commandAndArgument[1])));
                }
            }
            case ("user/delete") -> {
                if (loginService.checkLogin(commandAndArgument[2])) {
                userRepository.delete(Integer.parseInt(commandAndArgument[1]));
                }
            }
            case ("user/update") -> {
                if (loginService.checkLogin(commandAndArgument[2])) {
                    Buyer buyer1 = objectMapper.readValue(commandAndArgument[1], Buyer.class);
                    userRepository.update(buyer1);
                }
            }
            default -> System.out.println("Invalid command for UsersRepository");
        }
    }
}
