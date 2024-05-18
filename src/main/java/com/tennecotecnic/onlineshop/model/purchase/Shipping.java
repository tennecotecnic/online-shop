package com.tennecotecnic.onlineshop.model.purchase;

public class Shipping {

    private String address;
    private String phoneNumber;
    private Integer postalCode;


    public Shipping(String address, String phoneNumber, Integer postalCode) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }


    public Shipping() {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return "{\"address\":\"" + address
                + "\",\"phoneNumber\":\"" + phoneNumber
                + "\",\"postalCode\":" + postalCode + "}";
    }
}
