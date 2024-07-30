package com.tennecotecnic.onlineshop.model.user;

public enum Sex {
    MALE ("Men"),
    FEMALE ("Woman");
    private String title;

    Sex (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
