package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserFileRepository;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import java.io.IOException;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class UserController {

    private final UserRepository userRepository = new UserFileRepository();

    void processCommand(String stringFromReader) throws IOException {
        String[] commandAndArgument = stringFromReader.split("\\?");
        switch (commandAndArgument[0]) {
            case ("user/create"):
                User user = objectMapper.readValue(commandAndArgument[1], User.class);
                userRepository.create(user);
                break;
            case ("user/getAll"):
                PrintUtil.printUsers(userRepository.findAll());
                break;
            case ("user/get"):
                System.out.println(userRepository.findById(Integer.parseInt(commandAndArgument[1])));
                break;
            case ("user/delete"):
                userRepository.delete(Integer.parseInt(commandAndArgument[1]));
                break;
            case ("user/update"):
                User user1 = objectMapper.readValue(commandAndArgument[1], User.class);
                userRepository.update(user1);
                break;
            default:
                System.out.println("Invalid command for UsersRepository");
        }
    }
}
