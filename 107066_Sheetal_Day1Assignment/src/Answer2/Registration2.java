package Answer2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("userName");
		String sur=request.getParameter("surname");
		String login=request.getParameter("loginname");
		int age=Integer.parseInt(request.getParameter("age"));
		String[] top=request.getParameterValues("t1");
		
		User u=new User(name,sur,login,age,top);
		if(name.isEmpty()||sur.isEmpty()||login.isEmpty()||top.length==0){
			response.sendRedirect("index2.html");
		}
		else{
		out.println("<html><body>");
		out.println("<table border=10>");
		out.println("<tr><td>FirstName</td><td>"+name+"</td></tr>");
		out.println("<tr><td>surname</td><td>"+sur+"</td></tr>");
		out.println("<tr><td>loginname</td><td>"+login+"</td></tr>");
		out.println("<tr><td>age</td><td>"+age+"</td></tr>");
		
		for(String s:top){
			out.println(s);
		}
		out.println("</table>");
		out.println("</body></html>");
		}

	}

}
