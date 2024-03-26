package com.tennecotecnic.onlineshop.model;

public class Admin extends  User {

    public Admin(Integer id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
        this.setRole(Role.ADMIN);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "{\"id\":" + getId()
                + ",\"name\":\"" + getName()
                + "\",\"surname\":\"" + getSurname()
                + "\",\"email\":\"" + getEmail()
                + "\",\"password\":\"" + getPassword()
                + "\",\"role\":\"" + getRole() + "\"}";
    }
}
