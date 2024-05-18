package com.tennecotecnic.onlineshop.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.tennecotecnic.onlineshop.model.purchase.Purchase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class PurchaseFileRepository {

    private final String FINAL_NAME = "d:\\Projects\\online-shop\\purchasefilerepository.txt";
    private Integer currentIdGeneratorValue;
    private StringBuilder listBeforeCreateNewPurchase = new StringBuilder();


    public synchronized void create(Purchase purchase) {
        generateId();
        purchase.setId(currentIdGeneratorValue);
        try {
            writeToFile(listBeforeCreateNewPurchase
                    .append(objectMapper.writeValueAsString(purchase))
                    .append("\r\n")
                    .append("###")
                    .append(++currentIdGeneratorValue));
            listBeforeCreateNewPurchase.delete(0, listBeforeCreateNewPurchase.length());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public Collection<Purchase> findAll() {
        Collection<Purchase> purchaseList = new ArrayList<>();
        Purchase purchase = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String purchaseLine;
            while ((purchaseLine = reader.readLine()) != null && !purchaseLine.contains("###")) {
                purchase = objectMapper.readValue(purchaseLine, Purchase.class);
                purchaseList.add(purchase);
                }
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return purchaseList;
    }


    public Purchase findById(Integer searchingId) {
        boolean isPurchaseFound = false;
        Purchase purchase = null;
        String purchaseLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while (!isPurchaseFound && ((purchaseLine = reader.readLine()) != null)) {
                if (!purchaseLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(purchaseLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() == searchingId) {
                        isPurchaseFound = true;
                        purchase = objectMapper.readValue(purchaseLine, Purchase.class);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return purchase;
    }


    public Collection<Purchase> getAllByUserId(Integer userId) {
        Collection<Purchase> allUserPurchases = new ArrayList<>();
            Purchase purchase = null;
            String purchaseLine;
            try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
                while ((purchaseLine = reader.readLine()) != null) {
                    if (!purchaseLine.contains("###")) {
                        JsonNode rootNode = objectMapper.readTree(purchaseLine);
                        JsonNode idNode = rootNode.path("useId");
                        if (idNode.asInt() == userId) {
                            purchase = objectMapper.readValue(purchaseLine, Purchase.class);
                            allUserPurchases.add(purchase);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return allUserPurchases;
    }


//    public Purchase getLastUnpaidByUserId(Integer userId){
//        Purchase purchase = null;
//        String purchaseLine;
//        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
//            while ((purchaseLine = reader.readLine()) != null) {
//                if (!purchaseLine.contains("###")) {
//                    JsonNode rootNode = objectMapper.readTree(purchaseLine);
//                    JsonNode idNode = rootNode.path("userId");
//                    JsonNode statusNode = rootNode.path("status");
//                    if (idNode.asInt() == userId && statusNode.asText().equals("UNPAID")) {
//                        purchase = objectMapper.readValue(purchaseLine, Purchase.class);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return purchase;
//    }


   public void update(Purchase updatedPurchase) throws  IOException{
        StringBuilder rebuildPurchaseRepository = new StringBuilder();
        String purchaseLine;
        boolean isPurchaseFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while ((purchaseLine = reader.readLine()) != null) {
                if (!purchaseLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(purchaseLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() == updatedPurchase.getId()) {
                        isPurchaseFound = true;
                        String purchaseToWriteLine = objectMapper.writeValueAsString(updatedPurchase);
                        rebuildPurchaseRepository.append(purchaseToWriteLine).append("\r\n");
                    } else {
                        rebuildPurchaseRepository.append(purchaseLine).append("\r\n");
                    }
                } else {
                    rebuildPurchaseRepository.append(purchaseLine);
                }
            }
            if (!isPurchaseFound) {
                System.out.println("There is no purchase with this ID. Update is not possible.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(rebuildPurchaseRepository);
    }

    public void delete(Integer id) {
        StringBuilder rebuildPurchaseRepository = new StringBuilder();
        String purchaseLine;
        boolean isPurchaseFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while ((purchaseLine = reader.readLine()) != null) {
                if (!purchaseLine.contains("###")) {
                    JsonNode rootNode = objectMapper.readTree(purchaseLine);
                    JsonNode idNode = rootNode.path("id");
                    if (idNode.asInt() != id) {
                        rebuildPurchaseRepository.append(purchaseLine).append("\r\n");
                    } else {
                        isPurchaseFound = true;
                    }
                } else {
                    rebuildPurchaseRepository.append(purchaseLine);
                }
            }
            if (!isPurchaseFound) {
                System.out.println("There is no purchase with this ID. Delete is not possible.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeToFile(rebuildPurchaseRepository);
    }


    private void writeToFile(StringBuilder rebuildPurchaseRepository) {
        try (FileWriter fileWriter = new FileWriter(FINAL_NAME, false)) {
            fileWriter.write(rebuildPurchaseRepository.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private void generateId() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String purchaseLine;
            while ((purchaseLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(purchaseLine).append("\r\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String allPurchases = stringBuilder.toString();
        String [] idSetter = allPurchases.split("###");
        String [] idSetterArgument = idSetter[1].split("\r\n");
        currentIdGeneratorValue = Integer.parseInt(idSetterArgument[0]);
        listBeforeCreateNewPurchase.append(idSetter[0]);
    }
}
