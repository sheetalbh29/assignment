<%@page import="dao.DaoClass"%>
<%@ page errorPage="Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
%>
<jsp:useBean id="user" class="bean.User" scope="session" />
	<jsp:setProperty property="*" name="user"/>
	<%DaoClass dao=new DaoClass();
	if(user.isValidAge()){
	boolean a=dao.registerUser(user,path);
	if(a)
		response.sendRedirect("LoginAndRegister.jsp");		
	
	else 
		throw new Exception("Sorry Not Registered");
	}
	%>
</body>
</html>