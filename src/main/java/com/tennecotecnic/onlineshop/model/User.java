package com.tennecotecnic.onlineshop.model;
import java.time.Instant;
public class User {

    private Integer id;
    private String name;
    private String surName;
    private String e_mail;
    private Integer birthYear;
    private Sex sex;
    private Integer totalPurchasesCount;
    private Integer averagePurchasesPerDay;
    private Instant createdAt;
    public User(String name) {
        this.name = name;
    }


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


    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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

    public Integer getAveragePurchasesPerDay() {
        return averagePurchasesPerDay;
    }

    public void setAveragePurchasesPerDay(Integer averagePurchasesPerDay) {
        this.averagePurchasesPerDay = averagePurchasesPerDay;
    }

}
