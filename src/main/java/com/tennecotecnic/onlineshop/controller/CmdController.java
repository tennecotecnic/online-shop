package com.tennecotecnic.onlineshop.controller;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.PrintUtil;

import java.io.IOException;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class CmdController {


    private final UserRepository userRepository = new UserInMemoryRepository();


    void userDataProcessing(String data) throws IOException {

        String[] array = data.split("\\?");
        switch (array[0]) {
            case ("user/create"):
                User user = objectMapper.readValue(array[1], User.class);
                userRepository.create(user);
                break;
            case ("user/getAll"):
                PrintUtil.printUsers(userRepository.findAll());
                break;
            case ("user/get"):
                System.out.println(userRepository.findById(Integer.parseInt(array[1])));
                break;
            case ("user/delete"):
                userRepository.delete(Integer.parseInt(array[1]));
                break;
            case ("user/update"):
                User user1 = objectMapper.readValue(array[1], User.class);
                userRepository.update(user1);
                break;
            default:
                System.out.println("Invalid command for UsersRepository");
        }
    }
}
