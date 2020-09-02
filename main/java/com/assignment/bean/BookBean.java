package com.assignment.bean;

import com.assignment.model.Book;
import com.assignment.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBean implements BookBeanI {
    @Override
    public String add(Connection connection, Book book) {
        if (connection == null)
            return "FAILED TO GET CONNECTION";

        if (book == null)
            return "FAILED INVALID MEMBER DETAILS";

        try {
            PreparedStatement statement = connection.prepareStatement("insert into member(name,address,id,regNo) values(?,?,?,?)");
            statement.setString(1, book.getName() == null ? null : book.getName().toUpperCase());
            statement.setString(1, book.getBookId() == null ? null : book.getName().toUpperCase());
            statement.setString(2, book.getAuthor() == null ? null : book.getAuthor().toUpperCase());
            statement.setString(3, book.getTitle() == null ? null : book.getTitle().toUpperCase());
            statement.setString(4, book.getPrice() == null ? null : book.getPrice().toUpperCase());
            statement.executeUpdate();

        } catch (SQLException sqlEx) {
            return sqlEx.getCause().getMessage();

        }

        return "OK";
    }





    public List<Book> list(Connection connection) {
        List<Book> books = new ArrayList<Book>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM member");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Book book = new Book();
                book.setName(result.getString("name"));
                book.setBookId(result.getString("bookId"));
                book.setAuthor(result.getString("author"));
                book.setTitle(result.getString("title"));
                book.setPrice(result.getString("price"));
               // book.setAvailable(result.getString("name"));



                books.add(book);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return books;
    }
}

