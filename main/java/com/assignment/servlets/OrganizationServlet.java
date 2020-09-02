package com.assignment.servlets;


import com.assignment.bean.OrganizationBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.assignment.model.Organization;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import com.assignment.annotation.SaveToDb;
import com.assignment.bean.OrganizationBeanI;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;


@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {

    @Inject @SaveToDb
    private OrganizationBeanI organizationBean;

    @Inject
    private Organization organization;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(organizationBean.list(dbConnection)));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate (organization, request.getParameterMap());

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());

        }

        response.getWriter().print(organizationBean.add(dbConnection, organization));

    }

}
