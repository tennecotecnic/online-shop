package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Sex;
import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import java.util.Collection;
import java.util.HashMap;


public class UserInMemoryRepository implements UserRepository {

    public HashMap<Integer, User> userById = new HashMap<>();

    private Integer currentIdGeneratorValue = 11;

    public UserInMemoryRepository() {
        userById.put(1, new User(1, "John", "Travolta", "john@gmail.com", 1969, Sex.MALE));
        userById.put(2, new User(2, "Steeve", "Mcquin", "steeve@gmail.com", 1948, Sex.MALE));
        userById.put(3, new User(3, "Sunny", "Lane", "sun@gmail.com", 1985, Sex.FEMALE));
        userById.put(4, new User(4, "Mark", "Marques", "marco@gmail.com", 2000, Sex.MALE));
        userById.put(5, new User(5, "Inokentij", "Smoktunovsky", "kesha@gmail.com", 1928, Sex.MALE));
        userById.put(6, new User(6, "Rick", "Sanchez", "rik-cucumber@gmail.com", 1950, Sex.MALE));
        userById.put(7, new User(7, "Monika", "Belucchi", "belka@gmail.com", 1965, Sex.FEMALE));
        userById.put(8, new User(8, "Sam", "Vinchester", "sammy@gmail.com", 1985, Sex.MALE));
        userById.put(9, new User(9, "Din", "Vinchester", "din@gmail.com", 1980, Sex.MALE));
        userById.put(10, new User(10, "Maria", "Ivanova", "masha@gmail.com", 2005, Sex.FEMALE));
    }

    public void create(User user) {
        Integer currentId = generateId();
        user.setId(currentId);
        user.setCreatedAt(TimeFormatUtil.timeFormatSetting());
        user.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
        userById.put(currentId, user);
    }


    public Collection<User> findAll() {
        return userById.values();
    }


    public User findById(Integer id) {
        return userById.get(id);
    }


    public void update(User user) {
        user.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
        userById.put(user.getId(), user);
    }

    public void delete(Integer id) {
        userById.remove(id);
    }


    private Integer generateId() {
        return currentIdGeneratorValue++;
    }


}
