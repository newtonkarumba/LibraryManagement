<%@page import="java.sql.*"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*, com.assignment.utilities.DbConnection"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script src="./js/app.js"></script>
</head>
<body>
<%@ include file="./page/header.jsp"%>
    <hr/>
    <table>
        <tbody>
            <%
            String host = "jdbc:mysql://localhost:3306/Student";
            Connection conn = null;
            Statement stat = null;
            ResultSet res = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(host,"root","1234");
            stat = conn.createStatement();
            String data = "select * from user";
            res = stat.executeQuery(data);
            while(res.next()){
            %>
            <tr>
                <td><%=res.getString("id")%></td>
                <td><%=res.getString("name")%></td>
               <td>
               <a href




        </tbody>

    </table>



    <hr/>

    <form>
      <label for="fname"> Name</label>
      <input type="text" id="fname" name="fname">
      <input type="submit" value="Delete User"
                     onclick="deleteUser()"/>
    </form>
    <p id="deleted"> Delete: </p>



</body>
</html>