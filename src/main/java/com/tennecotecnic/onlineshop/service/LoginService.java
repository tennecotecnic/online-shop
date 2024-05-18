package com.tennecotecnic.onlineshop.service;

import com.tennecotecnic.onlineshop.model.user.User;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;

public class LoginService {
    private UserRepository userRepository;
    private HashMap<Integer, Instant> loginedUsers = new HashMap<>();

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login (String emailPassword) throws IOException {
        String[] emailAndPassword = emailPassword.split("&");
        String email = emailAndPassword[0];
        String password = emailAndPassword[1];
        Collection<User> users= userRepository.findAll();
        boolean isUserFound = false;
        for (User foundUser: users) {
            if ((foundUser.getEmail()).equals(email)) {
                isUserFound = true;
                if (password.equals(foundUser.getPassword())) {
                    Instant timeLogout = TimeFormatUtil
                            .timeFormatSetting()
                            .plusSeconds(60);
                    loginedUsers.put(foundUser.getId(), timeLogout);
                    System.out.println("Hi, " + foundUser.getName());
                    break;
                } else {
                    System.out.println("password not correct");
                    break;
                }
            }
        }
        if (!isUserFound) {
            System.out.println("user not found in base");
        }
    }


    public void logout (Integer userId) {
        loginedUsers.remove(userId);
    }


    public boolean checkLogin(Integer userId) throws IOException {
        boolean isUserLogined = true;
        if (loginedUsers.get(userId).compareTo(TimeFormatUtil.timeFormatSetting()) < 0) {
            isUserLogined = false;
            System.out.println("Authentication expired. Please login.");
        }
     return  isUserLogined;
    }


    public boolean checkAdminRole (Integer userId) throws IOException {
        boolean userIsAdmin = false;
        Collection<User> users= userRepository.findAll();
        for (User foundUser: users) {
            if ((foundUser.getId()).equals(userId)) {
                if (foundUser.getRole().equals(User.Role.ADMIN)) {
                    userIsAdmin = true;
                    break;
                } else {
                    System.out.println("No authorities for operation.");
                }
            }
        }
        return userIsAdmin;
    }
}
