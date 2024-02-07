package com.tennecotecnic.onlineshop.model;

import com.tennecotecnic.onlineshop.repository.UserInMemoryRepository;

public class Buyer {


    public Buyer (String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
        //this.id = giveId();
    }

    String name;
    private String login;
    private String password;

    public int giveId ( ) {
       // return 1000 + UserInMemoryRepository.numberInBase;
        return 999;
    }
}
