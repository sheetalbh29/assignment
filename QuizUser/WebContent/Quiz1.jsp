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
<body>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
HttpSession session1=request.getSession(false);
if(session1!=null){
	DaoClass dao=new DaoClass();
	ResultSet rs=(ResultSet)session.getAttribute("rs");
	rs.next();
	String topic=rs.getString(4);
//String topic=(String)session.getAttribute("topic");

%>
<form action="CheckAnswerServlet" method="get">	
ResultSet rs;
DBConfig db=new DBConfig();
ResultSet res=dao.getQuestion(topic,path);
String[] que={"que1","que2","que3","que4","que5"};
while(rs.next()){
	if(i<5){
		session.setAttribute(que[i],rs.getString(7));
	
	%>
	<h3>Que.<%=rs.getString(2) %></h3>
	<input type="radio" name="<%=que[i] %>" value="a"><%=rs.getString(3) %><br>
	<input type="radio" name="<%=que[i] %>" value="b"><%=rs.getString(4) %><br>
	<input type="radio" name="<%=que[i] %>" value="c"><%=rs.getString(5) %><br>
	<input type="radio" name="<%=que[i] %>" value="d"><%=rs.getString(6) %><br>
	
	<%
	i++;
	}
%>
<input type="submit" name="Submit" value="submit">	
</form>	
</body>
</html>




<td><h5>Specilization <%=rs.getString(4)%></h1></td>
		<td><h5>Day <%=rs.getInt(2)%></h1></td>
		<td><h5>Time <%=rs.getString(3)%></h1></td>