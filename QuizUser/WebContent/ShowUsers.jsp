<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DaoClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>-----------Users Detail-----------</h1>
<body>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
HttpSession session2=request.getSession(false);
		if(session2!=null){
			DaoClass dao=new DaoClass();
			ResultSet rs=(ResultSet)session.getAttribute("rs");
			while(rs.next()){
				%>
	    		<tr>
	    		<td><h5>Name: <%=rs.getString(1)%></h1></td>
	    		<td><h5>Password: <%=rs.getString(2)%></h1></td>
	    		<td><h5>Age: <%=rs.getInt(3)%></h1></td>
	    		<td><h5>Topic: <%=rs.getString(4)%></h1></td>
	    		</tr>
	    		<% 
			}
		}
		else 
		{
        	response.sendRedirect("LoginAndRegister.jsp");
        }
    %>
		<a href="Logout">LOGOUT</a>
	
</body>
</html>