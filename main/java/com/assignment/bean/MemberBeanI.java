package com.assignment.bean;
import com.assignment.model.Student;

import java.sql.Connection;
import java.util.List;
public interface MemberBeanI {
    String add(Connection connection, Student student);

    List<Student> list(Connection connection);
}
