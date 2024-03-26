package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Admin;
import com.tennecotecnic.onlineshop.model.Sex;
import com.tennecotecnic.onlineshop.model.Buyer;
import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import java.util.Collection;
import java.util.HashMap;


public class UserInMemoryRepository implements UserRepository {

    public HashMap<Integer, User> userById = new HashMap<>();

    private Integer currentIdGeneratorValue = 13;

    public UserInMemoryRepository() {
        userById.put(1, new Buyer(1, "John", "Travolta", "john@gmail.com", "qwerty", 1969, Sex.MALE));
        userById.put(2, new Buyer(2, "Steeve", "Mcquin", "steeve@gmail.com", "gfhjkm", 1948, Sex.MALE));
        userById.put(3, new Buyer(3, "Sunny", "Lane", "sun@gmail.com", "bootybabe", 1985, Sex.FEMALE));
        userById.put(4, new Buyer(4, "Mark", "Marques", "marco@gmail.com", "mark93", 2000, Sex.MALE));
        userById.put(5, new Buyer(5, "Inokentij", "Smoktunovsky", "kesha@gmail.com", "inok66", 1928, Sex.MALE));
        userById.put(6, new Buyer(6, "Rick", "Sanchez", "rik-cucumber@gmail.com", "c137rick", 1950, Sex.MALE));
        userById.put(7, new Buyer(7, "Monika", "Belucchi", "belka@gmail.com", "matrix", 1965, Sex.FEMALE));
        userById.put(8, new Buyer(8, "Sam", "Vinchester", "sammy@gmail.com", "padaleki", 1985, Sex.MALE));
        userById.put(9, new Buyer(9, "Din", "Vinchester", "din@gmail.com", "crowly", 1980, Sex.MALE));
        userById.put(10, new Buyer(10, "Maria", "Ivanova", "masha@gmail.com", "prostomaria", 2005, Sex.FEMALE));
        userById.put(11, new Admin(11, "Valdemar", "Valdemarov", "volder@gmail.com", "minecraft"));
        userById.put(12, new Admin(12, "Fireball", "", "12345@gmail.com", "borninussr"));
    }

    public void create(Buyer buyer) {
        Integer currentId = generateId();
        buyer.setId(currentId);
        buyer.setCreatedAt(TimeFormatUtil.timeFormatSetting());
        buyer.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
        userById.put(currentId, buyer);
    }


    public Collection<User> findAll() {
        return userById.values();
    }


    public User findById(Integer id) {
        return userById.get(id);
    }


    public void update(Buyer buyer) {
        User user = findById(buyer.getId());
        if (user instanceof Buyer) {
            buyer.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
            userById.put(buyer.getId(), buyer);
        } else {
            System.out.println("There is no buyer with this ID. Update is not possible.");
        }
    }

    public void delete(Integer id) {
        User user = findById(id);
        if (user instanceof Buyer) {
            userById.remove(id);
        } else {
            System.out.println("There is no buyer with this ID. Delete is not possible.");
        }
    }


    private Integer generateId() {
        return currentIdGeneratorValue++;
    }


}
