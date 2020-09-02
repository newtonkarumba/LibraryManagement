package com.assignment.model;
import java.util.*;

public class Book {
    private String name;
    private String bookId;
    private String author;
    private String title;
    private String price;
    private boolean Available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean Available() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }
}
