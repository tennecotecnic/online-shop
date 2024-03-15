package com.tennecotecnic.onlineshop.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tennecotecnic.onlineshop.model.Food;
import com.tennecotecnic.onlineshop.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.tennecotecnic.onlineshop.OnlineShop.objectMapper;

public class ProductFileRepository  implements  ProductRepository {
    private final String FINAL_NAME = "d:\\Projects\\online-shop\\productfilerepository.txt";

    private Integer currentIdGeneratorValue;
    private StringBuilder listBeforeCreateNewProduct = new StringBuilder();


    public void create(Product product) {
        generateId();
        product.setId(currentIdGeneratorValue);

        try {
            writeToFile(listBeforeCreateNewProduct.append(objectMapper.writeValueAsString(product))
                    .append("\r\n").append("###").append(++currentIdGeneratorValue));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        listBeforeCreateNewProduct.delete(0, listBeforeCreateNewProduct.length());
    }


    public Collection<Product> findAll() {
        Collection<Product> productList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String productLine;
            while ((productLine = reader.readLine()) != null) {
                Product product = objectMapper.readValue(productLine, Product.class);
                productList.add(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return productList;
    }


    public Product findById(Integer id) {
        boolean isProductFound = false;
        Product product = null;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            while (!isProductFound) {
                line = reader.readLine();
                product = objectMapper.readValue(line, Product.class);
                if ((product.getId()).equals(id)) {
                    isProductFound = true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }


    public void update(Product product) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FINAL_NAME))) {

            String productToWriteLine = objectMapper.writeValueAsString(product);

            String productReadLine;
            while ((productReadLine = bufferedReader.readLine()) != null) {
                Product productFound = objectMapper.readValue(productReadLine, Product.class);
                if ((product.getId()).equals(productFound.getId())) {
                    stringBuilder.append(productReadLine.replace(productReadLine, productToWriteLine)).append("\r\n");
                } else {
                    stringBuilder.append(productReadLine).append("\r\n");
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
            String productLine;
            while ((productLine = bufferedReader.readLine()) != null) {
                Product product = objectMapper.readValue(productLine, Product.class);
                if (!(product.getId()).equals(id)) {
                    stringBuilder.append(productLine).append("\r\n");
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
            String productLine;
            while ((productLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(productLine).append("\r\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String fullFile = stringBuilder.toString();
        String [] idSetter = fullFile.split("###");
        String [] idSetterArgument = idSetter[1].split("\r\n");
        currentIdGeneratorValue = Integer.parseInt(idSetterArgument[0]);
        listBeforeCreateNewProduct.append(idSetter[0]);
    }

}

