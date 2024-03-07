package com.tennecotecnic.onlineshop.repository;

import com.tennecotecnic.onlineshop.model.User;

import java.io.IOException;
import java.util.Collection;

public interface UserRepository {

    void create(User user);

    Collection<User> findAll() throws IOException;

    User findById(Integer id) throws IOException;

    void update(User user) throws IOException;

    void delete(Integer id) throws IOException;

}
