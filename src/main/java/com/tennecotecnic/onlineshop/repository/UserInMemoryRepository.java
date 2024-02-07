package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserInMemoryRepository {

    //String fileBaseOfBuyers = "d:\\Projects\\online-shop\\baseofbuyers.txt";

    public HashMap<Integer, User> usersRepository = new HashMap<>();
    public void create() {
        User user = new User();
        int size = usersRepository.size() + 1;
        usersRepository.put(size, user);
    }

    public Collection findAll() {
        return usersRepository.values();
    }

    public User findById(int id) {
        return usersRepository.get(id);
    }

    public void update(int id, User user) {
        usersRepository.remove(id);
        usersRepository.put(id, user);
    }

    public void delete(int id){
        usersRepository.remove(id);
    }

}
