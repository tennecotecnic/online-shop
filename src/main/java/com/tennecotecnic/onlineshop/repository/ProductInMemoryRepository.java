package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Product;
import com.tennecotecnic.onlineshop.model.*;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import com.tennecotecnic.onlineshop.model.Product.Category;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository  implements ProductRepository {

    public Map<Integer, Product> productById = new HashMap<>();
    private Integer currentIdGeneratorValue = 9;

    public ProductInMemoryRepository() {
        productById.put(1, new Book(1, Category.BOOK, 12.50f,
                "5-8451-0512-9", "Joanne Rowling", "Harry Potter and the Philosopher's Stone"));
        productById.put(2, new Car(2, Category.VEHICLE, 250000.0f, 1600,
                "Ferrari", "F40", 315, VehicleEnergyType.FUEL, VehicleType.CAR, "sportcar"));
        productById.put(3, new Food(3, Category.FOOD, 4.25f,
                "spagetti", "Barilla"));
        productById.put(4, new Moto(4, Category.VEHICLE, 3000.0f, 125,
                "Suzuki", "DRZ200", 130, VehicleEnergyType.FUEL, VehicleType.MOTO,
                2, false));
        productById.put(5, new Book(5, Category.BOOK, 35.0f,
                "5-8451-0578-9", "Stiven Hoking", "The universe"));
        productById.put(6, new Car(6, Category.VEHICLE, 2000.0f, 1600,
                "Volkswagen", "Golf 3", 150, VehicleEnergyType.FUEL, VehicleType.CAR, "hatchback"));
        productById.put(7, new Food(7, Category.FOOD, 7.67f,
                "Fish snacks", "Vici"));
        productById.put(8, new Moto(8, Category.VEHICLE, 25000.0f, 175,
                "Triumph", "Scrambler", 200, VehicleEnergyType.FUEL, VehicleType.MOTO,
                2, false));
    }


    public void create (Product product) {
        Integer currentId = generateId();
        product.setId(currentId);
        product.setCreatedAt(TimeFormatUtil.timeFormatSetting());
        product.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
        productById.put(currentId, product);
    }


    public Collection<Product> findAll() {
        return productById.values();
    }

    public Collection<Product> findByCategory(String findCategory) {
        Collection<Product> foundList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : productById.entrySet()) {
            Product product = entry.getValue();
            if ((product.getCategory().toString()).equals(findCategory)) {
                foundList.add(product);
            }
        }
        return foundList;
    }

    public Product findById(Integer id) {
        return productById.get(id);
    }

    public void update(Product product) {
        product.setUpdatedAt(TimeFormatUtil.timeFormatSetting());
        productById.put(product.getId(), product);
    }

    public void delete(Integer id) {
        productById.remove(id);
    }


    private Integer generateId() {
        return currentIdGeneratorValue++;
    }
}
