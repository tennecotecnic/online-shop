package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Product;

import java.io.IOException;
import java.util.Collection;

public interface ProductRepository {
    void create (Product product) throws IOException;

    Collection<Product> findAll() throws IOException;
    Collection<Product> findByCategory(String findCategory) throws IOException;

    Product findById(Integer id) throws IOException;

    void update(Product product) throws IOException;

    void delete(Integer id) throws IOException;
}
