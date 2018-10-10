package Answer3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=(String)request.getAttribute("userName"); 
		String upassw=(String)request.getAttribute("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("user name : "+uname);
		out.print("password : "+upassw);
		}
	}
