package com.assignment.bean;

import com.assignment.model.Organization;

import java.sql.Connection;
import java.util.List;

public interface OrganizationBeanI {

    String add(Connection connection, Organization organization);

    List<Organization> list(Connection connection);
}
