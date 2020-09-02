package com.assignment.bean;

import com.assignment.model.Organization;

import java.sql.Connection;
import java.util.List;
import com.assignment.annotation.SaveToDb;
import com.assignment.model.Organization;
import com.assignment.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SaveToDb
public class MemberBean implements MemberBeanI {
    public String add(Connection connection, Student student) {
        if (connection == null)
            return "FAILED TO GET CONNECTION";

        if (student == null)
            return "FAILED INVALID MEMBER DETAILS";

        try {
            PreparedStatement statement = connection.prepareStatement("insert into member(name,address,id,regNo) values(?,?,?,?)");
            statement.setString(1, student.getName() == null ? null : student.getName().toUpperCase());
            statement.setString(2, student.getAddress() == null ? null : student.getAddress().toUpperCase());
            statement.setString(3, student.getId() == null ? null : student.getId().toUpperCase());
            statement.setString(4, student.getRegNo() == null ? null : student.getRegNo().toUpperCase());
            statement.executeUpdate();

        } catch (SQLException sqlEx) {
            return sqlEx.getCause().getMessage();

        }

        return "OK";
    }

    public List<Student> list(Connection connection) {
        List<Student> students = new ArrayList<Student>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM member");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                Student student = new Student();
                student.setName(result.getString("name"));
                student.setAddress(result.getString("address"));
                student.setId(result.getString("id"));
                student.setRegNo(result.getString("regNo"));


                students.add(student);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return students;
    }
}