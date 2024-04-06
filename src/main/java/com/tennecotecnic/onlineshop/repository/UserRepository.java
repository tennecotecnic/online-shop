package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.Buyer;
import com.tennecotecnic.onlineshop.model.User;

import java.io.IOException;
import java.util.Collection;

public interface UserRepository {

    void create(Buyer buyer);

    Collection<User> findAll() throws IOException;

    User findById(Integer id) throws IOException;

    void update(Buyer buyer) throws IOException;

    void delete(Integer id) throws IOException;

}
