package com.assignment.bean;



import com.assignment.annotation.NotSaveToDb;
import com.assignment.annotation.SaveToDb;
import com.assignment.model.Organization;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@NotSaveToDb
public class OrganizationBean2 implements OrganizationBeanI {

    public String add(Connection connection, Organization organization) {
        System.out.println("nothing will be added!!!");
        return "OK";
    }

    public List<Organization> list(Connection connection) {
        List<Organization> organizations = new ArrayList<Organization>();
        Organization organization = new Organization();
        organization.setName("This is not from the database");
        organization.setAddress("So no address");
        organizations.add(organization);

        organization = new Organization();
        organization.setName("This is not from the database2");
        organization.setAddress("So no address2");
        organizations.add(organization);

        return organizations;

    }
}
