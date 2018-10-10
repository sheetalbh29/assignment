package Answer1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewPage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		HttpSession session = request.getSession(false);	
		session.setMaxInactiveInterval(20*60);
		
		if(session != null)
		{
			String username = (String)session.getAttribute("username");
			String SessionID = (String)session.getAttribute("sessionID");
			
			
			out.print("Welcome "+username);
			out.print("<br/>Session ID "+SessionID+"<hr/>");
							
		}
		else
		{
			response.sendRedirect("SignUp1.jsp");
		}
		
		
		
		
		
	}


	}
