<%@page import="java.sql.*"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
Sring id = request.getParameter("d");
int no = Integer.parseInt(id);
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","1234");
Statement stat = conn.createStatement();
stat.executeUpdate("delete from user where id='"+no+"'" );
response.sendRedirect("delete.jsp");
%>