package com.tennecotecnic.onlineshop.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tennecotecnic.onlineshop.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class UserFileRepository implements UserRepository {

    private final String FINAL_NAME = "d:\\Projects\\online-shop\\usersfilerepository.txt";
    private Integer currentIdGeneratorValue;
    private StringBuilder listBeforeCreateNewUser = new StringBuilder();


    public void create(User user) {
        generateId();
        user.setId(currentIdGeneratorValue);

        try {
            writeToFile(listBeforeCreateNewUser.append(objectMapper.writeValueAsString(user))
                    .append("\r\n").append("###").append(++currentIdGeneratorValue));
            listBeforeCreateNewUser.delete(0, listBeforeCreateNewUser.length());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public Collection<User> findAll() {
        Collection<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String userLine;
            while ((userLine = reader.readLine()) != null) {
                User user = objectMapper.readValue(userLine, User.class);
                userList.add(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }


    public User findById(Integer id) {
        boolean isUserFound = false;
        User user = null;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while (!isUserFound) {
                line = reader.readLine();
                user = objectMapper.readValue(line, User.class);
                if ((user.getId()).equals(id)) {
                    isUserFound = true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }


    public void update(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_NAME))) {

            String userToWriteLine = objectMapper.writeValueAsString(user);

            String userReadLine;
            while ((userReadLine = bufferedReader.readLine()) != null) {
                User userFound = objectMapper.readValue(userReadLine, User.class);
                if ((user.getId()).equals(userFound.getId())) {
                    stringBuilder.append(userReadLine.replace(userReadLine, userToWriteLine)).append("\r\n");
                } else {
                    stringBuilder.append(userReadLine).append("\r\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(stringBuilder);
    }


    public void delete(Integer id) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String userLine;
            while ((userLine = bufferedReader.readLine()) != null) {
                User user = objectMapper.readValue(userLine, User.class);
                if (!(user.getId()).equals(id)) {
                    stringBuilder.append(userLine).append("\r\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(stringBuilder);
    }

    private void writeToFile(StringBuilder stringBuilder) {
        try (FileWriter fileWriter = new FileWriter(FINAL_NAME, false)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void generateId() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String userLine;
            while ((userLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(userLine).append("\r\n");
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String allUsers = stringBuilder.toString();
        String [] idSetter = allUsers.split("###");
        String [] idSetterArgument = idSetter[1].split("\r\n");
        currentIdGeneratorValue = Integer.parseInt(idSetterArgument[0]);
        listBeforeCreateNewUser.append(idSetter[0]);
    }

}
