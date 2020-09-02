package com.assignment.bean;

import com.assignment.model.Book;

import java.sql.Connection;
import java.util.List;

public interface BookBeanI {
    String add(Connection connection, Book book);

    List<Book> list(Connection connection);
}
