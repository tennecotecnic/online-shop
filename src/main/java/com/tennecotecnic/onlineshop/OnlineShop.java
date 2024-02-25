package com.tennecotecnic.onlineshop;

import com.tennecotecnic.onlineshop.controller.CmdController;
import com.tennecotecnic.onlineshop.controller.ReadData;
import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;

public class OnlineShop {
    public static void main(String[] args)  throws Exception {

        UserInMemoryRepository userInMemoryRepository = new UserInMemoryRepository();

        UserInMemoryRepository.create(new User("Pablo"));
        UserInMemoryRepository.create(new User("Emilia"));
        System.out.println("inter your userData");
        CmdController.userDataProcessing(ReadData.readData());
        userInMemoryRepository.print(UserInMemoryRepository.dataBase);




    }
}
