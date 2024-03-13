package com.tennecotecnic.onlineshop.model;

import java.time.Instant;
public class User {


    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer birthYear;
    private Sex sex;
    private Integer totalPurchasesCount;
    private Integer averagePurchasesPerDay;
    private Instant createdAt;
    private Instant updatedAt;



    public User(Integer id, String name, String surname, String email, Integer birthYear, Sex sex) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthYear = birthYear;
        this.sex = sex;
        this.createdAt = Instant.now();
    }

    public User(String name) {
        this.name = name;
    }
    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getTotalPurchasesCount() {
        return totalPurchasesCount;
    }

    public void setTotalPurchasesCount(Integer totalPurchasesCount) {
        this.totalPurchasesCount = totalPurchasesCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAveragePurchasesPerDay() {
        return averagePurchasesPerDay;
    }

    public void setAveragePurchasesPerDay(Integer averagePurchasesPerDay) {
        this.averagePurchasesPerDay = averagePurchasesPerDay;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"surname\":\"" + surname + "\",\"email\":\"" + email + "\",\"birthYear\":" + birthYear + ",\"sex\":\"" + sex + "\",\"totalPurchasesCount\":" + totalPurchasesCount + ",\"averagePurchasesPerDay\":" + averagePurchasesPerDay + "}";
    }

}
