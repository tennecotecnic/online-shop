package com.tennecotecnic.onlineshop.model;

import java.time.Instant;
public class Buyer extends  User {

    private Integer birthYear;
    private Sex sex;
    private Integer totalPurchasesCount = 0;
    private Integer averagePurchasesPerDay = 0;


    public Buyer(Integer id, String name, String surname, String email, String password,
                 Integer birthYear, Sex sex) {
        super(id, name, surname, email, password);
        this.setRole(Role.BUYER);
        this.birthYear = birthYear;
        this.sex = sex;
    }

    public Buyer() {}


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
    @Override
    public String toString() {
        return "{\"id\":" + getId()
                + ",\"name\":\"" + getName()
                + "\",\"surname\":\"" + getSurname()
                + "\",\"email\":\"" + getEmail()
                + "\",\"password\":\"" + getPassword()
                + "\",\"role\":\"" + getRole()
                + "\",\"birthYear\":" + birthYear
                + ",\"sex\":\"" + sex
                + "\",\"totalPurchasesCount\":" + totalPurchasesCount
                + ",\"averagePurchasesPerDay\":" + averagePurchasesPerDay + "}";
    }

}
