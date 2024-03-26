package com.tennecotecnic.onlineshop.model;

public class Book extends Product {


    private String isbn;
    private String author;
    private String title;


    public Book(Integer id, Category category, float price, String isbn,
                String author, String title) {
        super(id, category, price);
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public Book() {}



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "{\"id\":" + getId()
                + ",\"category\":\"" + getCategory()
                + "\",\"price\":" + getPrice()
                + ",\"isbn\":\"" + isbn
                + "\",\"author\":\"" + author
                + "\",\"title\":\"" + title + "\"}";

              //+ "\",\"createdAt\":\"" + getCreatedAt() + "\",\"updatedAt\":\"" + getUpdatedAt() + "\"}";
    }
}
