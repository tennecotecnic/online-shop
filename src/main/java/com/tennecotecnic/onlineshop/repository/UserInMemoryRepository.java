package com.tennecotecnic.onlineshop.repository;

import java.util.Collection;
import java.util.HashMap;

import com.tennecotecnic.onlineshop.model.Sex;
import com.tennecotecnic.onlineshop.model.User;

public class UserInMemoryRepository {

    //String fileBaseOfBuyers = "d:\\Projects\\online-shop\\baseofbuyers.txt";

    private final HashMap<Integer, User> dataBase = new HashMap<>();

    private Integer currentIdGeneratorValue = 10;

    public UserInMemoryRepository() {
        dataBase.put(1, new User(1, "John", "Travolta", "john@gmail.com", 1969, Sex.MALE));
        dataBase.put(2, new User(2, "Steeve", "Mcquin", "steeve@gmail.com", 1948, Sex.MALE));
        dataBase.put(3, new User(3, "Sunny", "Lane", "sun@gmail.com", 1985, Sex.FEMALE));
        dataBase.put(4, new User(4, "Mark", "Marques", "marco@gmail.com", 2000, Sex.MALE));
        dataBase.put(5, new User(5, "Inokentij", "Smoktunovsky", "kesha@gmail.com", 1928, Sex.MALE));
        dataBase.put(6, new User(6, "Rick", "Sanchez", "rik-cucumber@gmail.com", 1950, Sex.MALE));
        dataBase.put(7, new User(7, "Monika", "Belucchi", "belka@gmail.com", 1965, Sex.FEMALE));
        dataBase.put(8, new User(8, "Sam", "Vinchester", "sammy@gmail.com", 1985, Sex.MALE));
        dataBase.put(9, new User(9, "Din", "Vinchester", "din@gmail.com", 1980, Sex.MALE));
        dataBase.put(10, new User(10, "Maria", "Ivanova", "masha@gmail.com", 2005, Sex.FEMALE));
    }

    public void create(User user) {
        Integer currentId = generateId();
        user.setId(currentId);
        dataBase.put(currentId, user);
    }

    public Collection<User> findAll() {
        return dataBase.values();
    }

    public User findById(Integer id) {
        return dataBase.get(id);
    }

    public void update(User user) {
        dataBase.put(user.getId(), user);
    }

    public void delete(Integer id) {
        dataBase.remove(id);
    }

    private Integer generateId() {
        return currentIdGeneratorValue++;
    }
}
