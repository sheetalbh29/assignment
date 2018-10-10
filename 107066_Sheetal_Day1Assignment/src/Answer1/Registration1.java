package Answer1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("userName");
		String sur=request.getParameter("surname");
		String login=request.getParameter("loginname");
		int age=Integer.parseInt(request.getParameter("age"));
		
		out.println("<html><body>");
		out.println("<table border=2>");
		out.println("<tr><td>FirstName</td><td>"+name+"</td></tr>");
		out.println("<tr><td>surname</td><td>"+sur+"</td></tr>");
		out.println("<tr><td>loginname</td><td>"+login+"</td></tr>");
		out.println("<tr><td>age</td><td>"+age+"</td></tr>");
		out.println("</table>");
		out.println("</body></html>");
	}

}
