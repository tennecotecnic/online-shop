package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.*;
import com.tennecotecnic.onlineshop.util.TimeFormatUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository  implements ProductRepository {

    public Map<Integer, Product> productById = new HashMap<>();
    private Integer currentIdGeneratorValue = 5;

    public ProductInMemoryRepository() {
        productById.put(1, new Book(1, Category.BOOK, 12.50f,
                "5-8451-0512-9", "Joanne Rowling", "Harry Potter and the Philosopher's Stone"));
        productById.put(2, new Car(2, Category.VEHICLE, 250000.0f, 1600,
                "Ferrari", "F40", 315, VihicleEnergyType.FUEL, VihicleType.CAR, "sportcar"));
        productById.put(3, new Food(3, Category.FOOD, 4.25f,
                "spagetti", "Barilla"));
        productById.put(4, new Moto(4, Category.VEHICLE, 25000.0f, 175,
                "Triumph", "Scrambler", 200, VihicleEnergyType.FUEL, VihicleType.MOTO,
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
