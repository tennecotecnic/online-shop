package com.tennecotecnic.onlineshop.service;

import com.tennecotecnic.onlineshop.model.User;
import com.tennecotecnic.onlineshop.repository.UserRepository;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;

public class LoginService {
    private UserRepository userRepository;
    private HashMap<String, Instant> loginedUsers = new HashMap<>();

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
                            .plusSeconds(180);
                    loginedUsers.put(email, timeLogout);
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


    public void logout (String email) {
        loginedUsers.remove(email);
    }


    public boolean checkLogin(String email) throws IOException {
        boolean isUserLogined = true;
        if (loginedUsers.get(email).compareTo(TimeFormatUtil.timeFormatSetting()) < 0) {
            isUserLogined = false;
            System.out.println("Authentication expired. Please login.");
        }
     return  isUserLogined;
    }


    public boolean checkAdminRole (String email) throws IOException {
        boolean userIsAdmin = false;
        Collection<User> users= userRepository.findAll();
        for (User foundUser: users) {
            if ((foundUser.getEmail()).equals(email)) {
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
