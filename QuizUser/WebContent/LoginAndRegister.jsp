<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DaoClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
DaoClass dao=new DaoClass();
ResultSet rs=dao.getTopic(path);
%>
<form action="LoginServlet" method="get">
<h1>Quiz Login</h1>
Username:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
<input type="submit" name="Login" value="login"><br>
</form>
------------------------------------------------------------------
<form action="Register.jsp">
<h1>Quiz User Registeration</h1>
Username:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
Age:<input type="number" name="age"><br>
Topic:<select name="topic">
<% 
while(rs.next())
{
%>
<option value=<%=rs.getString(1)%>><%=rs.getString(1) %></option>
<%
}
%>
</select>
<input type="submit" name="Register" value="register">
</form>
</body>
</html>