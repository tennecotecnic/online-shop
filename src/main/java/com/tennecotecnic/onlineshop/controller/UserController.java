package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.Buyer;
import com.tennecotecnic.onlineshop.repository.UserFileRepository;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import java.io.IOException;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class UserController {

    private final UserRepository userRepository = new UserFileRepository();
    //private final UserRepository userRepository = new UserInMemoryRepository();

    public void processCommand(String stringFromReader) throws IOException {
        String[] commandAndArgument = stringFromReader.split("\\?");
        switch (commandAndArgument[0]) {
            case ("user/create"):
                Buyer buyer = objectMapper.readValue(commandAndArgument[1], Buyer.class);
                userRepository.create(buyer);
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
                Buyer buyer1 = objectMapper.readValue(commandAndArgument[1], Buyer.class);
                userRepository.update(buyer1);
                break;
            default:
                System.out.println("Invalid command for UsersRepository");
        }
    }
}
