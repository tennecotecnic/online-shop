package com.tennecotecnic.onlineshop.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.tennecotecnic.onlineshop.model.Admin;
import com.tennecotecnic.onlineshop.model.Buyer;
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


    public void create(Buyer buyer) {
        generateId();
        buyer.setId(currentIdGeneratorValue);
        try {
            writeToFile(listBeforeCreateNewUser.append(objectMapper.writeValueAsString(buyer))
                    .append("\r\n").append("###").append(++currentIdGeneratorValue));
            listBeforeCreateNewUser.delete(0, listBeforeCreateNewUser.length());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public Collection<User> findAll() {
        Collection<User> userList = new ArrayList<>();
        User user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String userLine;
            while ((userLine = reader.readLine()) != null) {
                if (!userLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(userLine);
                    JsonNode roleNode = rootNode.path("role");
                    switch(roleNode.asText()) {
                        case("BUYER") -> {
                            user = objectMapper.readValue(userLine, Buyer.class);
                        }
                        case("ADMIN") -> {
                            user = objectMapper.readValue(userLine, Admin.class);
                        }
                    }
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }


    public User findById(Integer searchingId) {
        boolean isUserFound = false;
        User user = null;
        String userLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while (!isUserFound) {
                userLine = reader.readLine();
                if (!userLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(userLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() == searchingId) {
                        isUserFound = true;
                        JsonNode roleNode = rootNode.path("role");
                        switch(roleNode.asText()) {
                            case("BUYER") -> {
                                user = objectMapper.readValue(userLine, Buyer.class);
                            }
                            case("ADMIN") -> {
                                user = objectMapper.readValue(userLine, Admin.class);
                            }
                        }
                    }
                }
            }
            if (!isUserFound) {
                System.out.println("There is no buyer with this ID.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


    public void update(Buyer updatedBuyer) {
        StringBuilder rebuildUserRepository = new StringBuilder();
        String userLine;
        boolean isUserFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while ((userLine = reader.readLine()) != null) {
                if (!userLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(userLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() == updatedBuyer.getId()) {
                        isUserFound = true;
                        JsonNode roleNode = rootNode.path("role");
                        switch(roleNode.asText()) {
                            case("BUYER") -> {
                                String buyerToWriteLine = objectMapper.writeValueAsString(updatedBuyer);
                                rebuildUserRepository.append(buyerToWriteLine).append("\r\n");
                            }
                            case("ADMIN") -> {
                                System.out.println("this is the admin ID");
                                rebuildUserRepository.append(userLine).append("\r\n");
                            }
                        }
                    } else {
                        rebuildUserRepository.append(userLine).append("\r\n");
                    }
                }
            }
            if (!isUserFound) {
                System.out.println("There is no buyer with this ID. Update is not possible.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(rebuildUserRepository);
    }


    public void delete(Integer id) {
        StringBuilder rebuildUserRepository = new StringBuilder();
        String userLine;
        boolean isUserFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while ((userLine = reader.readLine()) != null) {
                if (!userLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(userLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() != id) {
                        rebuildUserRepository.append(userLine).append("\r\n");
                    } else {
                        isUserFound = true;
                        JsonNode roleNode = rootNode.path("role");
                        switch (roleNode.asText()) {
                            case ("BUYER") -> {
                                rebuildUserRepository.append("");
                            }
                            case ("ADMIN") -> {
                                System.out.println("this is the admin ID");
                                rebuildUserRepository.append(userLine).append("\r\n");
                            }
                        }
                    }
                }
            }
            if (!isUserFound) {
                System.out.println("There is no buyer with this ID. Delete is not possible.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(rebuildUserRepository);
    }


    private void writeToFile(StringBuilder rebuildUserRepository) {
        try (FileWriter fileWriter = new FileWriter(FINAL_NAME, false)) {
            fileWriter.write(rebuildUserRepository.toString());
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
